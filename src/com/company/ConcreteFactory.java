package com.company;

public class ConcreteFactory implements Factory {
    Singleton singleton=Singleton.getInstance();

    @Override
    public void createBlock() {
    }

    @Override
    public void createWall(int x,int y,int sizeX,int sizeY) {
        singleton.getVector().add(new wall(x,y,sizeX,sizeY));
    }
}
