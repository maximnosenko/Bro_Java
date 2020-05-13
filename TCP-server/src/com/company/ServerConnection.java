package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerConnection extends Thread {
    private Socket socket;
    private DataInputStream inStream;
    private DataOutputStream outStream;
    Singleton singleton;
    //private Server server;
    public ServerConnection(Socket sok,Singleton sing)
    {
        socket=sok;
        singleton.getMap().put(getPort(),this);
        System.out.println(singleton.getMap().keySet());
        Update();
        this.start();

    }
    public void run(){//клиент закрывается если минус -1 то удалить из мап
        try {
             inStream=new DataInputStream(socket.getInputStream());
             int close=inStream.readInt();
             if(close==-1)
             {
                 singleton.getMap().remove(getPort(),this);
             }
            //outStream.write(server.getHasMap());
            //Update();
            //inStream.close();
            //outStream.close();
            //socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int getPort()
    {
        return socket.getPort();
    }

    public void SendNotify()
    {
        try {
            outStream=new DataOutputStream(socket.getOutputStream());
            outStream.writeInt(singleton.getMap().size());
            for(Integer key:singleton.getMap().keySet())
                outStream.writeInt(key);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Update()
    {
        for(ServerConnection claind:singleton.getMap().values())
            claind.SendNotify();
        // map.get(key);
    }
}
