package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

public class Server {
    private static final int port=48655;

    //Socket s;
    //Singleton singleton=Singleton.getInstance();
    ServerSocket serverSock;//=new ServerSocket(port);
    Server() {
        try {
            serverSock=new ServerSocket(port);
            System.out.println("System works");
            while (true) {
                new ServerConnection(serverSock.accept());
                //Update();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //s.close();
            System.err.println(e);
        }
    }
}
