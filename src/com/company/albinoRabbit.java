package com.company;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class albinoRabbit extends AbstractRabbit {

    private BufferedImage image;

    albinoRabbit(int x, int y,long Birth,int ID) {
        this.x=x;
        this.y=y;
        this.BirthTime=Birth;
        this.ID=ID;
    }

    @Override
    long getTimeBirth() {
        return BirthTime;
    }

    @Override
    int getID() {
        return ID;
    }

    @Override
    void go() {
        System.out.println("Кролик альбинос идет");
    }

    @Override
    void stay() {
        System.out.println("Кролик альбинос стоит");
    }

    @Override
    public BufferedImage getImage() {
        try {
            image= ImageIO.read(new File("rabbiAlbonod.png") );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
