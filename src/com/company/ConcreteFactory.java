package com.company;

public class ConcreteFactory implements abstractFactory {

    int counterRabbit = 1;
    int counterAlbino = -1;
    private Singleton obj=Singleton.getInstance();
    @Override
    public void createRabbit(long BirthTime) {
        //System.out.println("fir fir fir");
        obj.GetIds().add(counterRabbit);
        obj.GetBirthTimes().put(BirthTime, counterRabbit);
        obj.GetVector().add(new Rabbits((int)(Math.random()*450),(int)(Math.random()*500),BirthTime,counterRabbit++));
    }

    @Override
    public void createAlbinoRabbit(long BirthTime) {
        //System.out.println("firrrrr firrrrr firrrrr");
        obj.GetIds().add(counterAlbino);
        obj.GetBirthTimes().put(BirthTime, counterAlbino);
        obj.GetVector().add(new albinoRabbit((int)(Math.random()*450),(int)(Math.random()*500),BirthTime,counterAlbino--));
    }
}
