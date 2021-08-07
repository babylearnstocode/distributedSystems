package Kap1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class IPKlasse {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress local = InetAddress.getLocalHost();
        InetAddress[] google = InetAddress.getAllByName("www.google.com");

        System.out.printf("Local IP Address: %s\nLocal Host name: %s\n", local.getHostAddress(), local.getHostName());

        for (int i = 0; i < google.length; i++) {
            System.out.printf("Google IP Address %d: %s\nGoogle Host %d: %s\n", i, google[i].getHostAddress(), i, google[i].getHostName());

        }


    }
}
