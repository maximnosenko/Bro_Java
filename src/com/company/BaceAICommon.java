package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//1.	Обыкновенные кролики двигаются хаотично со скоростью V. Хаотичность достигается случайной сменой направления движения раз в N секунд.
public class BaceAICommon extends AbstractBaceAI {
   // Singleton obj=Singleton.getInstance();
    Habitat habitat;
    int N=1000;
    boolean switching=true;
    boolean SwitchForSw=true;

    BaceAICommon() {
        singleton=Singleton.getInstance();
        V=10;
    }

    @Override
    public void run() {
        while (going) {
           // System.out.println(singleton.GetVector());
            for (AbstractRabbit rabbit : singleton.GetVector()) {
                if (rabbit.getID() > 0) {
                    //System.out.println("Rabbit go1");
                    //int w=rabbit.getX()
                    Timer timer=new Timer(N, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            if(SwitchForSw)
                            switching=false;
                            else
                                switching=true;
                        }
                    });
                    timer.start();
                    if(switching) {
                        rabbit.setCoordinates((int) (rabbit.getX() - Math.random() * V), (int) (rabbit.getY() - Math.random() * V));
                        SwitchForSw=true;
                    }
                    else {
                        rabbit.setCoordinates((int) (rabbit.getX() + Math.random() * V), (int) (rabbit.getY() + Math.random() * V));
                        SwitchForSw=false;
                    }
                }
            }
            try {
                Thread.sleep(500);
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
