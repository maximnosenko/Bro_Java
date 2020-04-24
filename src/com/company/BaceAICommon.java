package com.company;

import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.Map;

//1.	Обыкновенные кролики двигаются хаотично со скоростью V. Хаотичность достигается случайной сменой направления движения раз в N секунд.
public class BaceAICommon extends AbstractBaceAI {
    Singleton obj=Singleton.getInstance();

    BaceAICommon() {

        //    System.out.println("Constraction");
            run();
       //}
    }

    @Override
    public void run() {
        while (going) {
            System.out.println(obj.GetVector());
            for (AbstractRabbit rabbit : obj.GetVector()) {
                if (rabbit.getID() > 0) {
                    System.out.println("Rabbit go1");
                    //int w=rabbit.getX()
                    rabbit.setCoordinates(rabbit.getX() + 100, rabbit.getY() + 100);
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
