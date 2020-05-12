package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection extends Thread {
    private Socket socket;
    private DataInputStream inStream;
    private DataOutputStream outStream;
    private Server server;
    public ServerConnection(Socket sok,Server serv)
    {
        socket=sok;
        server=serv;
        start();
    }
    public void run(){
        try {
             inStream=new DataInputStream(socket.getInputStream());
             outStream=new DataOutputStream(socket.getOutputStream());
            //outStream.write(server.getHasMap());
            outStream.write(server.map.size());
            outStream.write(server.s.getPort());
            inStream.close();
            outStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
