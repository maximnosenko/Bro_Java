package com.company;
//2.	Альбиносы двигаются по оси X от одного края области обитания до другого со скоростью V.
public class BaceAIAlbino extends AbstractBaceAI {
    BaceAIAlbino()
    {
       singleton=Singleton.getInstance();
       V=15;
    }

    @Override
    public void run() {
        while (going) {
            for (AbstractRabbit rabbit : singleton.GetVector()) {
                if (rabbit.getID() < 0) {
                    //System.out.println("Rabbit go1");
                    //int w=rabbit.getX()
                    rabbit.setCoordinates((int) (rabbit.getX() - Math.random() * V), rabbit.getY());
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
