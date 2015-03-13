package com.aldebaran.examples;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.DynamicObjectBuilder;
import com.aldebaran.qi.QiService;
import com.aldebaran.qi.Session;

public class MyApplication {

    public static void main(String[] args) throws Exception {
        String robotUrl = "tcp://nao.local:9559";

        // Create a new application
        Application application = new Application(args, robotUrl);

        // Create an instance of your service
        QiService service = new HelloService();

        // Create a DynamicObjectBuilder, that will render your service
        // compatible with other supported languages.
        DynamicObjectBuilder objectBuilder = new DynamicObjectBuilder();
        service.init(objectBuilder.object());

        // Advertise the greet method contained in your HelloService service.
        // You need to specify its signature.
        objectBuilder.advertiseMethod("greet::s(s)", service,
                "Greets the caller");

        // Start your application
        application.start();

        // Retrieve the created session
        Session session = application.session();

        // Register your service in your session
        session.registerService("MyHelloService", objectBuilder.object());

        // Run your application
        application.run();
    }
}
