package com.micode.jumpolympics.game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class PlayingState implements JumpState{
    private final JumpManager jumpManager;
    private final Timer timer;

    public PlayingState(JumpManager jumpManager) {
        this.jumpManager = jumpManager;
        timer = new Timer(16, (ActionEvent e) -> jumpManager.updateGame());
        timer.start();
    }

    @Override
    public void update() {
        jumpManager.getChild().update();
        jumpManager.getObstacle().update();

        if (jumpManager.getChild().intersects(jumpManager.getObstacle())) {
            jumpManager.setState(new GameOverState(jumpManager));
        }
    }

    @Override
    public void render(Graphics g) {
        jumpManager.getChild().render(g);
        jumpManager.getObstacle().render(g);
    }
}
