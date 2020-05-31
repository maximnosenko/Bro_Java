package com.company;

import java.awt.*;

public class wall extends AbstractActor {
   // private int x,y,sizeX,sizeY;

    wall(int x,int y, int sizeX,int sizeY){
        this.x=x;
        this.y=y;
        this.sizeX=sizeX;
        this.sizeY=sizeY;
        setCoordinates(this.x,this.y);
    }

    @Override
    public void painting(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x,y,sizeX,sizeY);
        g.drawRect(x,y,sizeX,sizeY);
    }

    @Override
    public void setCoordinates(int x,int y) {
        this.x=x;
        this.y=y;
        right=x+sizeX;
        left=x;
        up=y;
        down=y+sizeY;
    }
}
