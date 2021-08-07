package Kap1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress local = InetAddress.getLocalHost();
        System.out.printf("Host name: %s\nIP Address: %s\n", local.getHostName(), local.getHostAddress());
    }
}
