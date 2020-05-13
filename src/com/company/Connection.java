package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection implements Runnable
{
    private Socket client;
    private DataInputStream inputStream;
    private Habitat h;
    private boolean running = true;

    Connection(Habitat habitat)
    {
        try {
            h = habitat;
            client = new Socket("localhost", 48655);
            inputStream = new DataInputStream(client.getInputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            try {
                int size = inputStream.readInt();
                h.TCPbox.removeAllItems();
                for (int i = 0; i < size; i++) {
                    int port = inputStream.readInt();
                    if (port != client.getLocalPort())
                        h.TCPbox.addItem(port);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void CloseConnection() {
        running = false;
        try {
            DataOutputStream data = new DataOutputStream(client.getOutputStream());
            data.writeInt(-1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
