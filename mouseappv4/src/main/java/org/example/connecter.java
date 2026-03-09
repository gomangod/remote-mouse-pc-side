package org.example;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class connecter {
    static String ip = Server.senderIP;
    public static void disconnect() throws IOException {
        Socket s = new Socket(ip,9112);
        OutputStreamWriter opsw = new OutputStreamWriter(s.getOutputStream());
        PrintWriter pw = new PrintWriter(opsw);
        pw.println("refused");
        opsw.close();
        s.close();
        System.out.println();
        Server.senderIP = null;
    }

    public static void connect() throws IOException {
        Socket s = new Socket(ip,9112);
        OutputStreamWriter opsw = new OutputStreamWriter(s.getOutputStream());
        PrintWriter pw = new PrintWriter(opsw);
        pw.println("Connect");
        opsw.close();
        s.close();
    }
}
