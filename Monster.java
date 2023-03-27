import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Monster extends Rectangle {
    int rxPosition;
    int yPosition;
    int width;
    int height;
    int yStepsToMove;
    BufferedImage monster;
    int movement = 6;
    Rectangle q;
    int monstid;

    Monster(int rxPosition, int yPosition, int w, int h, int monstid) {
        super(rxPosition, yPosition, 32, 32);
        this.rxPosition = rxPosition;
        this.yPosition = yPosition;
        this.width = w;
        this.height = h;
        this.monstid = monstid;
    }

    public void move() {
        yPosition += movement;
        q = new Rectangle(rxPosition, yPosition, 32, 32);
    }

    public void draw(Graphics g) {
        if (monstid == 0) {
            try {
                monster = ImageIO.read(new File("E:\\rohu\\study\\javaprojectsubmission\\spaceinv\\monster.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(monster, rxPosition, yPosition, null);
        } else {
            try {
                monster = ImageIO.read(new File("E:\\rohu\\study\\javaprojectsubmission\\spaceinv\\monster2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(monster, rxPosition, yPosition, null);
        }
    }
}
