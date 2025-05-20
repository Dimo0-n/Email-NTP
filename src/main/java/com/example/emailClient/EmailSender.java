package com.example.emailClient;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.File;
import java.nio.file.Files;
import java.util.Properties;
import java.util.Scanner;

public class EmailSender {

    public static void sendEmailText(String user, String password) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Destinatar: ");
        String to = scanner.nextLine();
        System.out.print("Subiect: ");
        String subject = scanner.nextLine();
        System.out.print("Mesaj: ");
        String messageText = scanner.nextLine();
        System.out.print("Reply-To (optional): ");
        String replyTo = scanner.nextLine();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(messageText, "UTF-8", "plain");

        if (!replyTo.trim().isEmpty()) {
            message.setReplyTo(new Address[]{new InternetAddress(replyTo.trim())});
        }

        Transport.send(message);
        System.out.println("Email trimis cu succes!");
    }

    public static void sendEmailWithAttachment(String user, String password) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Destinatar: ");
        String to = scanner.nextLine();
        System.out.print("Subiect: ");
        String subject = scanner.nextLine();
        System.out.print("Mesaj: ");
        String messageText = scanner.nextLine();
        System.out.print("Cale fisier: ");
        String filePath = scanner.nextLine();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(messageText);

        MimeBodyPart attachPart = new MimeBodyPart();
        File file = new File(filePath);
        if (file.exists()) {
            attachPart.attachFile(file);
            String fileName = file.getName();
            String mimeType = Files.probeContentType(file.toPath());
            attachPart.setContentID("<" + fileName + ">");

            if (mimeType != null) {
                attachPart.setHeader("Content-Type", mimeType + "; name=\"" + fileName + "\"");
            } else {
                attachPart.setHeader("Content-Type", "application/octet-stream; name=\"" + fileName + "\"");
            }
        } else {
            System.out.println("Fișierul nu a fost găsit!");
            return;
        }

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachPart);

        message.setContent(multipart);

        Transport.send(message);
        System.out.println("Email cu atașament trimis!");
    }

}
