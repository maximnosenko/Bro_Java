package com.company;

import javax.swing.*;

//Реализация интерфейсов и всякого прикольного
public class Game {
    JFrame frame;
    private Singleton singleton=Singleton.getInstance();

    private Habitat habitat=new Habitat(singleton);

    public Game(){
        frame=new JFrame("Arkanoid");
        frame.add(habitat);
        System.out.println(singleton.getVector());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850,700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
