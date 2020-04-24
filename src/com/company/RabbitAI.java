package com.company;

public class RabbitAI extends AbstractBaceAI {

    RabbitAI() {
        single = Singleton.getInstance();
    }
    @Override
    public void run()
    {
        while (going)
        {
            System.out.println(single.GetVector());
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                stopped();
            }
        }
    }

    @Override
    public void stopped() {

    }
}
