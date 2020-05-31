package com.company;

import javax.swing.*;
import java.awt.*;

public class Habitat extends JPanel implements Runnable{
    //int x1=10,y1=0,x2=10,y2=700;//0,0,0,700
    //int weight,height=0;
    boolean going= true;
    Singleton singleton = Singleton.getInstance();
    private ConcreteFactory factory= new ConcreteFactory();
    Ball ball;

    public Habitat(Singleton singleton) {
        this.singleton = singleton;
        factory.createWall(0,0,1,700);
        factory.createWall(830,0,1,700);
        factory.createWall(0,0,850,1);
        factory.createWall(0,652,850,1);
        new Thread(this).start();
        //factory.createBoll();
        ball=new Ball(420,500,20,20);//420,500,20,20
        new Thread(ball).start();
        //платформу и стены сделать тут
    }

    public void paint(Graphics graphics) {
        super.paintComponent(graphics);
        ball.painting(graphics);
        for(AbstractActor actor:singleton.getVector()) {
            actor.painting(graphics);
            if(actor.right>ball.left&&actor.left<ball.right&&actor.up<ball.down&&actor.down>ball.up){
            //actor.right>ball.left && actor.getX()<ball.getX()&&actor.down>ball.up&&ball.down<actor.up&&actor.left<ball.left
                ball.onCollision();
                System.out.println("fsaf");
                //continue;

                //going=false;
            //singleton.getVector().get(i).painting(graphics);
            }

        }
    }

    @Override
    public void run() {
        while (going) {
            try {
                Thread.sleep(70);
                repaint();
            } catch (InterruptedException e) {
                going=false;
            }
        }
        //проверка есть ли колизия каждые 100 милисекунд проверять
        //проверить через цикл пересечения с шариком проверить не пересекаютсяли
        //if(xsize(одного obj) - xsize(другого)) onColision
    }
}