package com.company;

import java.awt.*;

public interface Behavior {
    void painting(Graphics g);
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    void setCoordinates(int x,int y);
}
