package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

public class Server {
    private static final int port=48655;
    //Socket s;
    Singleton singleton=Singleton.getInstance();
    ServerSocket serverSock;//=new ServerSocket(port);
    Server() throws IOException {
        serverSock=new ServerSocket(port);
        try {
            System.out.println("System works");
            while (true) {
                new ServerConnection(serverSock.accept(),singleton);
                //Update();
            }
        }
        catch (Exception e)
        {
            //s.close();
            e.fillInStackTrace();
            System.err.println(e);
        }
    }


}
