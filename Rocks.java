import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Rocks extends Rectangle {
    int rxPosition; // random x-axis position
    int yPosition; // y position always at little below from the top
    int width; // width of the rock
    int height; // height of the rock
    int yStepsToMove; // steps to move keep moving 10 steps( int movement) and go out of the screen
    BufferedImage rock; // image of the rock
    int movement = 8;
    Rectangle p;

    int rockid;

    Rocks(int rxPosition, int yPosition, int w, int h, int rockid) {
        super(rxPosition, yPosition, 32, 32); // Spanning a rectangle for the rock image
        this.rxPosition = rxPosition;
        this.yPosition = yPosition;
        width = w;
        height = h;
        this.rockid = rockid;
    }

    public void move() {
        yPosition += movement;
        p = new Rectangle(rxPosition, yPosition, 32, 32);
    }

    public void draw(Graphics g) {

        if (rockid == 0) {
            try {
                rock = ImageIO.read(new File("E:\\rohu\\study\\javaprojectsubmission\\spaceinv\\alien.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(rock, rxPosition, yPosition, null);
        } else if (rockid == 1) {
            try {
                rock = ImageIO.read(new File("E:\\rohu\\study\\javaprojectsubmission\\spaceinv\\alien2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(rock, rxPosition, yPosition, null);
        } else if (rockid == 2) {
            try {
                rock = ImageIO.read(new File("E:\\rohu\\study\\javaprojectsubmission\\spaceinv\\alien3.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(rock, rxPosition, yPosition, null);
        } else if (rockid == 3) {
            try {
                rock = ImageIO.read(new File("E:\\rohu\\study\\javaprojectsubmission\\spaceinv\\alien4.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(rock, rxPosition, yPosition, null);
        } else {
            try {
                rock = ImageIO.read(new File("E:\\rohu\\study\\javaprojectsubmission\\spaceinv\\alien5.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(rock, rxPosition, yPosition, null);
        }

    }
}
