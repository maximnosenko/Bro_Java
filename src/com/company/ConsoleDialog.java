package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PipedWriter;
import java.util.Iterator;

public class ConsoleDialog extends JDialog implements Runnable{
    PipedWriter pw;
    Singleton singleton;

    ConsoleDialog(Singleton sing)
    {
     singleton=sing;
     pw=new PipedWriter();
     System.out.println("Hello");
    }

    PipedWriter getStream(){return pw;}

    ConsoleDialog() {
        final JTextArea textArea = new JTextArea();
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                super.keyPressed(keyEvent);
                if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    String[] lines = textArea.getText().split("\n");
                    String result = Execute(lines[lines.length-1]);
                    textArea.setText("");
                    if (result != "")
                    {
                        for (String line: lines) {
                            textArea.append(line);
                            textArea.append("\n");
                        }
                        textArea.append(result);
                    }
                }
            }
        });
        JPanel contents = new JPanel();
        contents.add(textArea);
        contents.setLayout(new GridLayout(1, 1));
        setContentPane(contents);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void run() {
        new ConsoleDialog();
    }

    public String Execute(String command)
    {
        if (command.equals("clear")) {
            return "";
        }
        String[] parts = command.split(" ");
        if (parts.length == 3 && parts[0].equals("reduce") && parts[1].equals("albino"))
        {
            try {
                int reduce = Integer.parseInt(parts[2]);
                ReduceAlbino(reduce);
            }
            catch (NumberFormatException e)
            {
                return "Incorrect parameter for reduce albino command";
            }
            return "Albino number is reduced!";
        }
        return "Unknown command";
    }

    public int getCurrentAlbinoNumber()//нужен для различия альбиноса от обычного кролика
    {
        int result = 0;
        for (AbstractRabbit rabbit: singleton.GetVector())
        {
            if (rabbit.getID() < 0)
                result++;
        }
        return result;
    }

    public void ReduceAlbino (int number) {
        int i = getCurrentAlbinoNumber()*number/100;
        System.out.println(i);
        int deleted = 0;
        Iterator<AbstractRabbit> iter = singleton.GetVector().iterator();
        while (iter.hasNext())
        {
            if (deleted < i)
            {
                AbstractRabbit rabbit = iter.next();
                if (rabbit.getID() < 0)
                {
                    singleton.GetMap().remove(rabbit.getID());
                    singleton.getID().remove(rabbit.getID());
                    iter.remove();
                    try {
                        pw.write(String.valueOf(singleton.GetVector()));//????????????????????????????
                        pw.write(String.valueOf(singleton.getID()));//???????????????????
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    deleted++;
                }
            }
            else
                break;
        }
    }

}
