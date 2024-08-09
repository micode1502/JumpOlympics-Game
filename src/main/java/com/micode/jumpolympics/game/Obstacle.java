package com.micode.jumpolympics.game;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Obstacle {
    private int x, y;
    private final int width, height;
    private final Image image;

    public Obstacle() {
        x = 800;
        y = 380;
        width = 17;
        height = 33;
        image = new ImageIcon(getClass().getResource("/obstacle.png")).getImage();
    }

    public void update() {
        x -= 5;
        if (x < -width) {
            x = 800;
        }
    }

    public void render(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}