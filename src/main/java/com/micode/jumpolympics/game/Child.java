package com.micode.jumpolympics.game;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Child {
    private int x, y, velocityY;
    private final int groundY = 350;
    private boolean jumping;
    private final Image image;

    public Child() {
        x = 50;
        y = groundY;
        velocityY = 0;
        jumping = false;
        image = new ImageIcon(getClass().getResource("/child.png")).getImage();
    }

    public void update() {
        if (jumping) {
            velocityY += 1;
            y += velocityY;
            if (y >= groundY) {
                y = groundY;
                jumping = false;
                velocityY = 0;
            }
        }
    }

    public void jump() {
        if (!jumping) {
            jumping = true;
            velocityY = -15;
        }
    }

    public void render(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    public boolean intersects(Obstacle obstacle) {
        return x < obstacle.getX() + obstacle.getWidth() &&
               x + image.getWidth(null) > obstacle.getX() &&
               y < obstacle.getY() + obstacle.getHeight() &&
               y + image.getHeight(null) > obstacle.getY();
    }
}
