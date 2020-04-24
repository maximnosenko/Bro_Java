package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//1.	Обыкновенные кролики двигаются хаотично со скоростью V. Хаотичность достигается случайной сменой направления движения раз в N секунд.
public class BaceAICommon extends AbstractBaceAI {
   // Singleton obj=Singleton.getInstance();
    int N=200;
    boolean switching=true;
    boolean SwitchForSw=true;

    BaceAICommon(Habitat h) {
        super(h);
        singleton=Singleton.getInstance();
        V=10;
    }

    @Override
    public void run() {
        while (going) {
           // System.out.println(singleton.GetVector());
            synchronized (singleton.GetVector()) {
                for (AbstractRabbit rabbit : singleton.GetVector()) {
                    if (rabbit.getID() > 0) {
                        //System.out.println("Rabbit go1");
                        //int w=rabbit.getX()
                        rabbit.setCoordinates((int) (rabbit.getX() + rabbit.getDirX() * V), (int) (rabbit.getY() - rabbit.getDirY() * V));
                        if ((habitat.currentTime - rabbit.getTimeBirth()) % N == 0) {
                            rabbit.SetDir(Math.random() * 2 - 1, Math.random() * 2 - 1);
                        }
                    }
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                stopped();
            }
        }
    }

    @Override
    public void stopped() {
        going=false;
    }
}
