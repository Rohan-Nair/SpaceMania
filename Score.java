import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Score extends Rectangle {
    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    BufferedImage banner;
    int playerScore = 0;

    Score(int GAME_WIDTH, int GAME_HEIGHT) {
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }

    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        g.setFont(new Font("Ugly Byte", Font.PLAIN, 30));
        g.drawString("score: " + playerScore, GAME_WIDTH - 150, 100);
        try {
            banner = ImageIO.read(new File("E:\\rohu\\study\\javaprojectsubmission\\spaceinv\\banner.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int bannerwidth = banner.getWidth();
        int bannerheight = banner.getHeight();
        g.drawImage(banner, GAME_WIDTH / 2 - bannerwidth / 2, bannerheight, null);
    }
}
