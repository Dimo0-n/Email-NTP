package com.example.emailClient;

import jakarta.mail.*;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EmailReceiver {

    public static void receiveEmailsPOP3(String user, String password) throws Exception {
        Properties props = new Properties();
        props.put("mail.pop3.host", "pop.gmail.com");
        props.put("mail.pop3.port", "995");
        props.put("mail.pop3.ssl.enable", "true");

        Session session = Session.getInstance(props);
        Store store = session.getStore("pop3s");
        store.connect("pop.gmail.com", user, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();
        int maxEmails = 25;
        int totalMessages = messages.length;
        int start = Math.max(1, totalMessages - maxEmails + 1);

        System.out.println("Total emailuri: " + totalMessages);
        for (int i = start; i <= totalMessages; i++) {
            Message msg = messages[i - 1];
            System.out.println("\n------------------");
            System.out.println("Subiect: " + msg.getSubject());
            System.out.println("De la: " + msg.getFrom()[0]);
            if (msg.getContentType().contains("multipart")) {
                saveAttachments(msg);
            }
        }

        inbox.close(false);
        store.close();
    }

    public static void receiveEmailsIMAP(String user, String password) throws Exception {
        Properties props = new Properties();
        props.put("mail.imap.ssl.enable", "true");

        Session session = Session.getInstance(props);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", user, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();
        int maxEmails = 25;
        int totalMessages = messages.length;
        int start = Math.max(1, totalMessages - maxEmails + 1);

        System.out.println("Total emailuri: " + totalMessages);
        for (int i = start; i <= totalMessages; i++) {
            Message msg = messages[i - 1];
            System.out.println("\n------------------");
            System.out.println("Subiect: " + msg.getSubject());
            System.out.println("De la: " + msg.getFrom()[0]);
            if (msg.getContentType().contains("multipart")) {
                saveAttachments(msg);
            }
        }

        inbox.close(false);
        store.close();
    }

    private static void saveAttachments(Message message) throws Exception {
        Multipart multipart = (Multipart) message.getContent();

        String downloadFolderPath = System.getProperty("user.dir") + File.separator + "downloads";
        File downloadFolder = new File(downloadFolderPath);
        if (!downloadFolder.exists()) {
            downloadFolder.mkdirs();
        }

        for (int i = 0; i < multipart.getCount(); i++) {
            BodyPart part = multipart.getBodyPart(i);

            if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                String filename = part.getFileName();
                File downloadFile = new File(downloadFolderPath + File.separator + filename);

                try (FileOutputStream output = new FileOutputStream(downloadFile)) {
                    ((MimeBodyPart) part).saveFile(downloadFile);
                    System.out.println("Atașament salvat: " + filename);
                } catch (IOException e) {
                    System.out.println("Eroare la salvarea atașamentului " + filename + ": " + e.getMessage());
                }
            }
        }
    }

}
