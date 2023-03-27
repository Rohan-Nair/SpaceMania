import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class RootPanel extends JPanel implements Runnable {
    static final int GAME_HEIGHT = 750;
    static final int GAME_WIDTH = 650;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int ROCKET_HEIGHT = 192;
    static final int ROCKET_WIDTH = 192;
    static final int ROCK_WIDTH = 192;
    static final int ROCK_HEIGHT = 192;
    static final int MONSTER_HEIGHT = 192;
    static final int MONSTER_WIDTH = 192;
    static final int COIN_WIDTH = 192;
    static final int COIN_HEIGHT = 192;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Rocket playerRocket;
    Monster monster;
    Rocks rocks;
    Coins coins;
    Score score;

    RootPanel() {
        newRocket();
        newRocks();
        newMonster();
        newCoins();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newRocket() {
        playerRocket = new Rocket((GAME_WIDTH / 2) - (ROCKET_WIDTH / 2), ROCKET_HEIGHT * 3, ROCKET_WIDTH,
                ROCKET_HEIGHT);
    }

    public void newRocks() {
        random = new Random();
        int rockXSpawn = random.nextInt(GAME_WIDTH - ROCK_WIDTH);
        int rockid = random.nextInt(6);
        rocks = new Rocks(rockXSpawn, 0, ROCK_WIDTH, ROCK_HEIGHT, rockid);
    }

    public void newMonster() {
        random = new Random();
        int monsterXSpawn = random.nextInt(GAME_WIDTH - MONSTER_WIDTH);
        int monstid = random.nextInt(2);
        monster = new Monster(monsterXSpawn, 0, MONSTER_WIDTH, MONSTER_HEIGHT, monstid);
    }

    public void newCoins() {
        random = new Random();
        int coinXSpawn = random.nextInt(GAME_WIDTH - COIN_WIDTH);
        coins = new Coins(coinXSpawn, 0, COIN_WIDTH, COIN_HEIGHT);
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        playerRocket.draw(g);
        rocks.draw(g);
        monster.draw(g);
        coins.draw(g);
        score.draw(g);
    }

    public void move() {
        playerRocket.move();
        rocks.move();
        monster.move();
        coins.move();
    }

    public void checkCollision() {
        // stops rocket from going out of the screen
        if (playerRocket.xPosition <= 0) {
            playerRocket.xPosition = 0;
        }
        if (playerRocket.xPosition >= (GAME_WIDTH - ROCKET_WIDTH)) {
            playerRocket.xPosition = GAME_WIDTH - ROCKET_WIDTH;
        }

        // collision
        if (rocks.p.intersects(playerRocket.r)) {
            rocks.movement = 0;
            playerRocket.movement = 0;
            monster.movement = 0;
            coins.movement = 0;
        }

        if (rocks.yPosition >= GAME_HEIGHT) {
            newRocks();
        }

        // collison
        if (monster.q.intersects(playerRocket.r)) {
            rocks.movement = 0;
            playerRocket.movement = 0;
            monster.movement = 0;
            coins.movement = 0;
        }

        if (rocks.yPosition == GAME_HEIGHT / 2) {
            newMonster();
        }

        if (monster.yPosition >= GAME_HEIGHT) {
            newMonster();
        }

        if (coins.s.intersects(playerRocket.r)) {
            score.playerScore++;
            newCoins();
            System.out.println(score.playerScore);
        }

        if (coins.yPosition >= GAME_HEIGHT) {
            newCoins();
        }
    }

    public void run() {
        // gameloop
        long lastTime = System.nanoTime();
        double fps = 60.0;
        double ns = 1000000000 / fps; // ns -> nanoseconds
        double delta = 0;
        boolean running = true;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;

            }
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            playerRocket.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            playerRocket.keyReleased(e);
        }
    }
}
