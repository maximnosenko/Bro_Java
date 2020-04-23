package com.company;

public abstract class AbstractRabbit implements InBehavior {

    int x,y;
    long BirthTime;
    int ID;

    protected AbstractRabbit() { }

    abstract long getTimeBirth();

    abstract int getID();

    abstract void go();
    abstract void stay();

    AbstractRabbit(int x,int y,long Birth,int ID)
    {
        this.x=x;
        this.y=y;
        this.BirthTime=Birth;
        this.ID=ID;
    }
}
