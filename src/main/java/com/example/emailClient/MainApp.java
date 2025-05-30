package com.example.emailClient;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String email = "dumitrufrimu118@gmail.com";
        String appPassword = "Parola mea de aplicatie de la gmail";

        while (true) {
            System.out.println("\n=== EMAIL CLIENT ===");
            System.out.println("1. Vezi emailuri (POP3)");
            System.out.println("2. Vezi emailuri (IMAP)");
            System.out.println("3. Trimite email (text)");
            System.out.println("4. Trimite email (cu atașament)");
            System.out.println("5. Iesi");

            System.out.print("Alege optiune: ");
            int opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1:
                    EmailReceiver.receiveEmailsPOP3(email, appPassword);
                    break;
                case 2:
                    EmailReceiver.receiveEmailsIMAP(email, appPassword);
                    break;
                case 3:
                    EmailSender.sendEmailText(email, appPassword);
                    break;
                case 4:
                    EmailSender.sendEmailWithAttachment(email, appPassword);
                    break;
                case 5:
                    System.out.println("Vina si maine!");
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }
}
