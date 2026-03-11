package org.example;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class connecter {
    public static void disconnect() throws IOException {
        String ip = Server.senderIP;
        Socket s = new Socket(ip,9112);
        OutputStreamWriter opsw = new OutputStreamWriter(s.getOutputStream());
        PrintWriter pw = new PrintWriter(opsw,true);
        pw.println("refused");
        pw.flush();
        opsw.close();
        s.close();
        Server.senderIP = null;
    }

    public static void connect() throws IOException {
        String ip = Server.senderIP;
        Socket s = new Socket(ip,9112);
        OutputStreamWriter opsw = new OutputStreamWriter(s.getOutputStream());
        PrintWriter pw = new PrintWriter(opsw,true);
        pw.println("Connect");
        pw.flush();
        opsw.close();
        s.close();
    }
}
