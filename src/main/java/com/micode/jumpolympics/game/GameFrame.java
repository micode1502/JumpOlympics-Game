package com.micode.jumpolympics.game;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Juego de Saltar");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);

        JumpManager jumpManager = JumpManager.getInstance();
        jumpManager.startGame();
    }
}
