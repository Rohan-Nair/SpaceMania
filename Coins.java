import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Coins extends Rectangle {
    int rxPosition;
    int yPosition;
    int width;
    int height;
    int yStepsToMove;
    int movement = 5;
    BufferedImage coin;
    Rectangle s;

    Coins(int rxPosition, int yPosition, int w, int h) {
        super(rxPosition, yPosition, 62, 62);
        this.rxPosition = rxPosition;
        this.yPosition = yPosition;
        this.width = w;
        this.height = h;
    }

    public void move() {
        yPosition += movement;
        s = new Rectangle(rxPosition, yPosition, 32, 32);
    }

    public void draw(Graphics g) {
        try {
            coin = ImageIO.read(new File("E:\\rohu\\study\\javaprojectsubmission\\spaceinv\\coins.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(coin, rxPosition, yPosition, null);
    }
}
