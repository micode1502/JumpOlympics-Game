package com.micode.jumpolympics.game;

import java.util.List;
import java.util.ArrayList;

public class JumpManager {
    private static JumpManager instance;
    private JumpState currentState;
    private final List<JumpObserver> observers = new ArrayList<>();
    private Child child;
    private Obstacle obstacle;
    
    private JumpManager(){
        child = new Child();
        obstacle = new Obstacle();
    }
    
    // Singleton Pattern
    public static JumpManager getInstance() {
        if (instance == null) {
            instance = new JumpManager();
        }
        return instance;
    }

    public void startGame() {
        setState(new PlayingState(this));
    }

    public void updateGame() {
        currentState.update();
        notifyObservers();
    }

    public void renderGame(java.awt.Graphics g) {
        currentState.render(g);
    }

    public void addObserver(JumpObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (JumpObserver observer : observers) {
            observer.onGameUpdate();
        }
    }
    
    public void setState(JumpState state) {
        this.currentState = state;
    }

    public Child getChild() {
        return child;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }
}
