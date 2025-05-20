package com.example.ntp;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

import java.net.InetAddress;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class NtpClientApp {

    private static final String NTP_SERVER = "pool.ntp.org";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdu zona geografică (ex: GMT+2 sau GMT-5): ");
        String timeZoneInput = scanner.nextLine().toUpperCase().trim();

        if (!timeZoneInput.matches("GMT[+-](\\d|1[01])")) {
            System.out.println("Format invalid. Folosește ex: GMT+2 sau GMT-5");
            return;
        }

        try {

            NTPUDPClient client = new NTPUDPClient();
            client.setDefaultTimeout(5000);
            InetAddress inetAddress = InetAddress.getByName(NTP_SERVER);
            TimeInfo timeInfo = client.getTime(inetAddress);
            timeInfo.computeDetails();

            long serverTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();

            Instant instant = Instant.ofEpochMilli(serverTime);
            ZoneId zoneId = ZoneId.of(timeZoneInput);
            ZonedDateTime zonedDateTime = instant.atZone(zoneId);

            System.out.println("Ora exactă pentru " + timeZoneInput + " este: " + zonedDateTime.toLocalTime());

        } catch (Exception e) {
            System.out.println("Eroare la conectarea la serverul NTP: " + e.getMessage());
        }
    }
}
