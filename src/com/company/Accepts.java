package com.company;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Accepts implements Runnable {
    private PipedReader pr;

    Accepts(PipedWriter pw) throws IOException {
        try {
            pr = new PipedReader(pw);
        }
        catch (IOException e)
        {
            System.err.println("this wrong "+e);
        }
    }

    PipedReader getStream(){return pr;}

    @Override
    public void run() {
            try {
                System.out.println("read: "+pr.read());
            } catch (IOException e) {
                System.out.println("finished");
            }

    }
}
