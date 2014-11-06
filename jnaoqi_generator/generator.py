import os
import sys

__author__ = 'epinault'

from qi import Session
import pprint

TEMPLATE_VOID = """
    /**
    * %(method_desc)s
    * %(method_params)s
    */
    public %(outtype)s %(methodName)s(%(args)s) throws CallError, InterruptedException{
        if (isAsynchronous)
            service.call("%(method)s"%(extraparams)s);
        else
            service.call("%(method)s"%(extraparams)s).get();
    }"""

TEMPLATE_RETURN = """
    /**
    * %(method_desc)s
    * %(method_params)s
    */
    public %(outtype)s %(methodName)s(%(args)s) throws CallError, InterruptedException {
        return (%(outtype)s)service.call("%(method)s"%(extraparams)s).get();
    }"""

TEMPLATE_CLASS = """package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;
import java.util.List;
import java.util.Map;
import com.aldebaran.qimessaging.*;

import java.util.List;

/**
 * Created by erwan and emile on 01/05/2014.
 */
public class %(module_name)s extends ALModule {

    public %(module_name)s(Session session) {
        super(session);
    }
%(content)s
}
    """
ALMEMORY_BUG = """public void addMapping(String param1, Map<String param2, String> param3) throws CallError, InterruptedException{
          service.call("addMapping", param1, param2, param3).get();
    }"""
ALMEMORY_FIX = """public void addMapping(String param1, Map<String,String> param2) throws CallError, InterruptedException{
          service.call("addMapping", param1, param2).get();
    }"""




BLACKLIST_METHODS = set("registerEvent, unregisterEvent, metaObject, terminate, property, setProperty, registerEventWithSignature, _setDetectionMode, enableStats, enableTrace, __pCall, pCall, stats, properties".split(", "))
BLACKLIST_MODULES = set("ALTabletService")

doc = ""

OPENERS, CLOSERS = '([{<', ')]}>'
EXPECTED_CLOSER = dict(zip(OPENERS, CLOSERS))

def get_subtrees(closer, symbols):
    trees = []
    while symbols:
        head = symbols[0]
        tail = symbols[1:]
        if head in OPENERS:
            subtrees, symbols = get_subtrees(EXPECTED_CLOSER[head], tail)
            if head != '<': # Fuck <, man.
                trees.append((head, subtrees))
        elif head in CLOSERS:
            assert head == closer, "Unexpected closer, got %s, expected %s" % (head, closer)
            return trees, tail
        else:
            trees.append(head)
            symbols = tail
    return trees, ''

def totree(symbols):
    trees, symbols = get_subtrees('', symbols)
    return trees

##############################################################
# Tests
##############################################################


BASIC_TYPE = {
        '[': 'List<',
        '{': 'Map<',
         "i": "Integer",
         "I": "Integer",
         "c": "Character",
         "s": "String",
         "v": "void",
         "o": "com.aldebaran.qimessaging.Object",
         "X": "java.lang.Object",
         "b": "Boolean",
         "m": "java.lang.Object",
         "f": "Float",
         "L":"Long",
         "l":"Long",
         "d":"Double"
}

COMPLEX_TYPE = ()

def parseTree(trees, names, level):
    result = ""

    for i, entry in enumerate(trees):
        if isinstance(entry, tuple):
            kind, subtrees = entry
            if kind  == "(":
                result += "Tuple"+str(len(subtrees))+"<"
            else:
                result += BASIC_TYPE[kind]
            # typesTranslated.append(NAMES[kind])

            result += parseTree(subtrees, None, level + 1)
            if level == 0:
                result += "> "+names[i]+", "
            else:
                result += ">, "

        else:
            if level == 0:
                result += BASIC_TYPE[entry] + " "+names[i]+", "
            else:
                result += BASIC_TYPE[entry] + ", "
            # typesTranslated.append(NAMES[entry])
    result = result [0:-2]
    return result

def translate(typecode):
    tree = totree(typecode)
    return parseTree(tree, None, 1)

def camelcasify(s):
    words = s.split()
    return words[0] + "".join([w.capitalize() for w in words[1:]])


def translateArgument(signatures, paraminfo):
    anonvari = [0]
    def getvarname(d):
        if d and d['name'] and d['name'] != "string" :
            return d['name']
        else:
            anonvari[0] += 1
            return "param%i" % anonvari[0]
    names = map(getvarname, paraminfo)
    names = map(cleanJavaName, names)
    names = map(camelcasify, names)

    tree = totree(signatures[1:-1])
    for i, t in enumerate(tree):
        if i+1 > len(names):
            names.append(getvarname(None))

    if len(tree) != len(names):
        names = names[0:len(tree)]
        print names
    return parseTree(tree,names, 0), ", ".join(names)


# def translate2(typecode):
#     return typemap2.get(typecode, "Object")
#
# def translateType(stype):
#     print map(translate2, stype)


def cleanJavaName(name):
    if name == "package":
        return "getPackage2"
    if name == "int":
        return "integer"
    if name == "string":
        return "string1"
    if name == "service":
        return "serviceName"
    else:
        return name


def translateFunc(methodData):
    # return "     " + translate(method["returnSignature"]) + " " + method["name"] + "(" +  translateArgument(method["parametersSignature"], method["parameters"]) + ")"
    outtype = translate(methodData["returnSignature"])
    method = methodData["name"]
    method_desc = methodData["description"]
    methodName = cleanJavaName(method)
    args, extraparams = translateArgument(methodData["parametersSignature"], methodData["parameters"])
    if extraparams :
        extraparams = ", "+extraparams

    method_params = ""
    for param in methodData["parameters"]:
        method_params += "\n    * @param "+param["name"]+"  "+param["description"]

    if outtype == "void":
        return TEMPLATE_VOID % locals()
    else:
        if methodData["returnDescription"]:
            method_params += "\n    * @return "+methodData["returnDescription"]
        return TEMPLATE_RETURN % locals()

def native(method):
    return "     " + method["returnSignature"] + " " + method["name"] +  method["parametersSignature"]
    # return "     " + method["returnSignature"] + " " + method["name"] + "(" +  method["parametersSignature"] + ")"

def _iter_services(address):
    session = Session()
    session.connect('tcp://'+address+':9559')

    for servicesDesc in session.services():
        module_name = servicesDesc["name"]
        if not module_name.startswith('_'):
            yield module_name, session.service(module_name)

def generate_java(address):
    directory = "generate/src/com/aldebaran/qimessaging/helpers/al"
    if not os.path.exists(directory):
        os.makedirs(directory)

    for module_name, service in _iter_services(address):

        if module_name not in BLACKLIST_MODULES:
            content = ""
            meta = service.metaObject()
            desc = meta["description"]
            methods = meta["methods"]

            # print "Service %s" % (module_name)
            # print methods.values()
            for method in methods.values() :
                # print native(method)
                if method["name"] not in BLACKLIST_METHODS:
                    content += translateFunc(method)+"\n"

            with open(directory+"/"+module_name + ".java", "w") as outfile:
                outfile.write(TEMPLATE_CLASS % locals())
                outfile.close()
        # break



def find_errors():
    for module_name, service in _iter_services():
        meta = service.metaObject()
        undocumented = []
        complained = [False]
        def complain():
            if not complained[0]:
                complained[0] = True
                print
                print module_name + ":"
        for methodData in meta["methods"].values():
            methodname = methodData["name"]
            signatures = methodData["parametersSignature"].strip("()")
            paramDescs = methodData["parameters"]
            paramNames = [d['name'] for d in methodData["parameters"]]
            if len(signatures) < len(paramNames):
                complain()
                print "  PROBLEM IN %s.%s(%s)" %(module_name, methodname, signatures)
                print "    expected %i args, doc gives %i: %s" % (len(signatures), len(paramNames), ", ".join(paramNames))
                #pprint.pprint(paramDescs)
                #print " signature", signatures
                #return
            elif (len(signatures) > len(paramNames)) and (methodname not in BLACKLIST_METHODS) and (not methodname.startswith('_'))\
                    and ("[" not in signatures) and ("{" not in signatures):
                undocumented.append(methodname + methodData["parametersSignature"])
        if undocumented:
            complain()
            print "  %i functions with undocumented params: %s" % (len(undocumented), ", ".join(undocumented))




EXAMPLE = {'description': 'Set if the input concepts are copied', 'parameters': [
    {'name': 'copyInput', 'description': 'False to optimize'}], 'parametersSignature': '(({I(Issss[(ss)<MetaMethodParameter,name,description>]s)<MetaMethod,uid,returnSignature,name,parametersSignature,description,parameters,returnDescription>}{I(Iss)<MetaSignal,uid,name,signature>}{I(Iss)<MetaProperty,uid,name,signature>}s)<MetaObject,methods,signals,properties,description>)', 'name': '_copyInputConcepts', 'returnDescription': '', 'returnSignature': 'v', 'uid': 238L}
    # {'name': '', 'description': 'False to optimize'}], 'parametersSignature': '(i[f][f][f][f][f][f][f][f])', 'name': '_copyInputConcepts', 'returnDescription': '', 'returnSignature': 'v', 'uid': 238L}

def test():
    print "================================"
    pprint.pprint(EXAMPLE)
    print "================================"
    print translateFunc(EXAMPLE)
    print "================================"

if __name__ == "__main__":

    if len(sys.argv) < 2:
        print "ip or name.local of the robot needed"
    else:
        generate_java(sys.argv[1])
    # test()
    # find_errors()