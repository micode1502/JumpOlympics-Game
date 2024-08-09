package com.micode.jumpolympics.game;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements JumpObserver {
    private final JumpManager jumpManager;

    public GamePanel() {
        jumpManager = JumpManager.getInstance();
        jumpManager.addObserver(this);

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    jumpManager.getChild().jump();
                }
            }
        });
    }

    @Override
    public void onGameUpdate() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        jumpManager.renderGame(g);
    }
}
