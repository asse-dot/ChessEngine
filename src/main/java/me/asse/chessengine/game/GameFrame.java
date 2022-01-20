package me.asse.chessengine.game;

import javax.swing.*;

public class GameFrame extends JFrame {

    private static GamePanel gamePanel = new GamePanel();

    public GameFrame() {
        this.add(gamePanel);
        this.setTitle("Chess Engine");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }

    public static GamePanel getGamePanel() {
        return gamePanel;
    }
}
