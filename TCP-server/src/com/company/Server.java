package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    private static final int port=4004;
    Socket s;
    HashMap map =new HashMap();
    private ServerSocket serverSock;
    Server() throws IOException {
        serverSock=new ServerSocket(port);
        try {
            System.out.println("System works");
            while (true) {
                s=serverSock.accept();
                map.put(s.getPort(),new ServerConnection(s,this));
                //System.out.println(s.getPort());
                //System.out.println(s);
                //ServerConnection ss=new ServerConnection(s);
                //ss.start();
            }
        }
        catch (Exception e)
        {
            s.close();
            System.err.println(e);
        }
        finally {
            serverSock.close();
        }
    }

}
