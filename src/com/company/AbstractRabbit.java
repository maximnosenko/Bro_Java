package com.company;

public abstract class AbstractRabbit implements InBehavior {

    int x,y;
    long BirthTime;
    int ID;

    protected AbstractRabbit() {
    }
    abstract void setCoordinates(int x,int y);
    abstract long getTimeBirth();

    abstract int getID();

    AbstractRabbit(int x,int y,long Birth,int ID)
    {
        this.x=x;
        this.y=y;
        this.BirthTime=Birth;
        this.ID=ID;
    }
}
