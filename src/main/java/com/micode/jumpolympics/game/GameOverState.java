package com.micode.jumpolympics.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameOverState implements JumpState {

    private final JumpManager jumpManager;

    public GameOverState(JumpManager jumpManager) {
        this.jumpManager = jumpManager;
    }

    @Override
    public void update() {
        // No se actualiza en el estado de Game Over
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("Game Over", 300, 200);
    }
    
}
