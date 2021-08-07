package Kap1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lookup {
    public static void main(String[] args) {
        try {
            InetAddress[] address = InetAddress.getAllByName(args[0]);
            for (int i = 0; i < address.length; i++) {
                System.out.printf("Looking up for %d: %s -> Host name: %s | Ip Address: %s", i, args[0], address[i].getHostName(), address[i].getHostAddress());

            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}

