package com.company;

public class ConcreteFactory implements abstractFactory {
    int IDRabbit=1;
    int IDAlbino=-1;
    private Singleton obj=Singleton.getInstance();

    @Override
    public void createRabbit(long BirthTime) {
        obj.getID().add(IDRabbit);
        obj.GetMap().put(BirthTime,IDRabbit);
        obj.GetVector().add(new Rabbits((int)(Math.random()*450),(int)(Math.random()*500),BirthTime,IDRabbit++));
    }

    @Override
    public void createAlbinoRabbit(long BirthTime) {
        obj.getID().add(IDAlbino);
        obj.GetMap().put(BirthTime,IDAlbino);
        obj.GetVector().add(new albinoRabbit((int)(Math.random()*450),(int)(Math.random()*500),BirthTime,IDAlbino--));
    }
}