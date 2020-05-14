package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection implements Runnable {
    private Habitat habitat;
    private Socket client;
    private DataInputStream inputStream;
    private Boolean running=true;
    DataOutputStream data;
    Connection(Habitat h){
        habitat=h;
        System.out.println("program is works");
        try {
            client=new Socket("localhost",48655);
            inputStream=new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            try {
                int size = inputStream.readInt();
                habitat.TCPbox.removeAllItems();
                habitat.TCPbox.addItem(" ");
                for (int i = 0; i < size; i++) {
                    int port = inputStream.readInt();
                    if(port!=client.getLocalPort()) {
                        System.out.println(port);
                        habitat.TCPbox.addItem(port);
                    }
                    System.out.println("oll ports: "+port);
                    //Vector.add(port);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void CloseConnection(){
        running=false;
        try {
        data = new DataOutputStream(client.getOutputStream());
            data.writeInt(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastTread()
    {
        try {
            data = new DataOutputStream(client.getOutputStream());
            data.writeInt(1);
            data.writeInt((Integer) habitat.TCPbox.getSelectedItem());
            data.writeDouble(habitat.N1);
            data.writeDouble(habitat.N2);
            //System.out.println(N1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
