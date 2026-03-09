package org.example;


import java.io.*;
import java.net.*;
import java.util.Timer;


public class Server {

     static int port = 9123;
     static RemoteMouseUI remoteMouseUI;

    static {
        try {
            remoteMouseUI = new RemoteMouseUI();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    ;
     static DatagramSocket socket;
    public static String senderIP;






    public Server() throws UnknownHostException {
        remoteMouseUI.run("no device connected");
    }

    public void RUN() throws IOException, InterruptedException {
        StartServer();
    }

    public static void STOP(){
        remoteMouseUI.updateLabel3("Stopped searching");
        socket.close();
    }
    public static void client(String ServerIP, int Port) throws IOException {
        String ip = String.valueOf(Inet4Address.getLocalHost().getHostAddress());
        System.out.println(ip);
        Socket s = new Socket(ServerIP,Port);
        OutputStreamWriter opsw = new OutputStreamWriter(s.getOutputStream());
        PrintWriter pw = new PrintWriter(opsw);
        pw.println(ip);
        opsw.close();
        s.close();
        connectionlistner connectionlistner = new connectionlistner();
        connectionlistner.listner();
    }

    public static void StartServer() throws IOException {try {
        remoteMouseUI.updateLabel3("Started searching");
        socket = new DatagramSocket(port);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String message = new String(packet.getData(), 0, packet.getLength());
        String sdsenderIP = String.valueOf(packet.getAddress());
        remoteMouseUI.updateLabel1(String.valueOf(packet.getAddress()));
        senderIP = sdsenderIP.substring(1);
        int senderport = Integer.parseInt(message);
        System.out.println(message + senderIP);
        client(senderIP,senderport);
        socket.close();
        remoteMouseUI.updateLabel3("Stopped searching");
        remoteMouseUI.severstrated = false;
    }catch (IOException e){
        System.out.println("stopped");
    }}



}
