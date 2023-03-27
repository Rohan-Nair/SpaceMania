import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class RootFrame extends JFrame {

    RootPanel panel;

    RootFrame() {
        // setting the icon of window
        ImageIcon icon = new ImageIcon("invader.png");

        panel = new RootPanel();
        this.add(panel);
        this.setTitle("Space Mania"); // setting the title of the window
        this.setResizable(false);
        this.setBackground(new Color(9, 8, 26));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        // this.setLocationRelativeTo(null); // sets the window to the center of the
        // screen
        this.setLocation(450, 5);
        this.setIconImage(icon.getImage()); // setting the favicon of the window
        this.pack();
    }
}
