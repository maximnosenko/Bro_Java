package com.company;
//2.	Альбиносы двигаются по оси X от одного края области обитания до другого со скоростью V.
public class BaceAIAlbino extends AbstractBaceAI {
    BaceAIAlbino (Habitat h)
    {
        super(h);
        singleton=Singleton.getInstance();
        V=15;
    }

    @Override
    public void run() {
        while (going) {
            synchronized (singleton.GetVector()) {
                for (AbstractRabbit rabbit : singleton.GetVector()) {
                    if (rabbit.getID() < 0) {
                        //System.out.println("Rabbit go1");
                        //int w=rabbit.getX()
                        if ((rabbit.getX() + rabbit.getDirX() * V + 50) >= habitat.getPanelWidth()
                        || (rabbit.getX() + rabbit.getDirX() * V) <= 0)
                            rabbit.SetDir(-rabbit.getDirX(), 0);
                        rabbit.setCoordinates((int) (rabbit.getX() + rabbit.getDirX() * V), rabbit.getY());
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
