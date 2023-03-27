import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Rocket extends Rectangle {
    // Rectangle class extended to get intersects method to check for collision
    int xVelocity;
    int xPosition;
    int yPosition;
    int movement = 10;
    BufferedImage ship;

    Rectangle r;
    int width;
    int height;

    Rocket(int xPosition, int yPosition, int ROCKET_WIDTH, int ROCKET_HEIGHT) {
        super(xPosition, yPosition, 62, 62); // spanning a rectangle around the rocket
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        width = ROCKET_WIDTH;
        height = ROCKET_HEIGHT;
    }

    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_D) || (e.getKeyCode() == KeyEvent.VK_RIGHT)) {
            setXDirection(movement);
            move();
        }
        if ((e.getKeyCode() == KeyEvent.VK_A) || (e.getKeyCode() == KeyEvent.VK_LEFT)) {
            setXDirection(-movement);
            move();
        }
    }

    public void keyReleased(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_D) || (e.getKeyCode() == KeyEvent.VK_RIGHT)) {
            setXDirection(0);
            move();
        }
        if ((e.getKeyCode() == KeyEvent.VK_A) || (e.getKeyCode() == KeyEvent.VK_LEFT)) {
            setXDirection(0);
            move();
        }
    }

    public void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }

    public void move() {
        xPosition += xVelocity;
        r = new Rectangle(xPosition, yPosition, 62, 62);
    }

    public void draw(Graphics g) {
        // g.setColor(new Color(219, 155, 4));
        try {
            ship = ImageIO.read(new File("E:\\rohu\\study\\javaprojectsubmission\\spaceinv\\rocketship.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(ship, xPosition, yPosition, null);
    }
}
