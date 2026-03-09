package org.example;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;

public class connectionlistner {

public void listner() throws IOException {
    ServerSocket ss = new ServerSocket(9111);
    DataInputStream dataInputStream = new DataInputStream(ss.accept().getInputStream());
    String message = dataInputStream.readLine();
    ss.close();
    POP_UP1 popUp1 = new POP_UP1();
    popUp1.RUN(message);
}
}
