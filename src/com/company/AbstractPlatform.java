package com.company;

public abstract class AbstractPlatform extends AbstractActor implements Runnable,PlayerControl {

    int speed,maxX,maxY;

    AbstractPlatform(int x,int y,int maxX ,int maxY)
    {
        this.x=x;
        this.y=y;
        this.maxX=maxX;
        this.maxY=maxY;
    }

    @Override
    public void moveRight() {

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void createBoll() {

    }

    @Override
    public void run() {

    }
}
