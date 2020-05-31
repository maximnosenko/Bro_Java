package com.company;


public abstract class AbstractBlock extends AbstractActor implements Distractible {
    int points;
    AbstractBlock(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public void Destroy() {//удаление

    }
}
