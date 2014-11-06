package com.aldebaran.demo.picture;

import com.aldebaran.demo.RobotIP;
import com.sun.mail.smtp.SMTPTransport;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

    private static String MAIL_TITLE = "JavaOne 2014";
    private static String MAIL_MESSAGE = "Here is the picture";

    public void sendPicture(String filename) throws Exception {
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");

        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        // -- Create a new message --
        final MimeMessage msg = new MimeMessage(session);

        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress("nao@aldebaran-robotics.com"));
//        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RobotIP.RCPT_EMAIL, false));

        msg.setSubject(MAIL_TITLE);
        msg.setSentDate(new Date());

        // -- Add attachment --
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(MAIL_MESSAGE);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(filename);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName("LJC.png");
        multipart.addBodyPart(messageBodyPart);
        msg.setContent(multipart);


        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

        System.out.println("Connecting ...");
//        t.connect("smtp.gmail.com", RobotIP.MAIL_USERNAME, RobotIP.MAIL_PASSWORD);
        System.out.println("Sending email ...");
        Thread.currentThread().setContextClassLoader( getClass().getClassLoader() );
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();
        System.out.println("Done");
    }
}
