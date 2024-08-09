package com.micode.jumpolympics.game;

import javax.swing.SwingUtilities;

/**
 *
 * @author Dara
 */
public class JumpOlympicsGame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFrame frame = new GameFrame();
            frame.setVisible(true);
        });
    }
}
