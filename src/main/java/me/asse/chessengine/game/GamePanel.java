package me.asse.chessengine.game;

import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.material.PawnWhite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener{
    public final static int dimension_y = 600;
    public final static int dimension_x = 600;
    public final static int unitsize_x = dimension_x/8;
    public final static int unitsize_y = dimension_y/8;

    public List<Position> highlightsMoss = new ArrayList<Position>();

    public Graphics g;
    private List<Piece> allPiece = new ArrayList<Piece>();



    public GamePanel() {
        this.setPreferredSize(new Dimension(dimension_x, dimension_y));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.startGame();
        this.addMouseListener(new MyMouseAdapter());
    }

    public void startGame() {
        this.allPiece.add(new PawnWhite(null, Position.a2 ,1));
        this.allPiece.add(new PawnWhite(null, Position.a3, 1));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
        this.g = g;
    }

    public void draw(Graphics g) {

        for(int y = 0; y<8; y++) {
            for(int x = 0; x<8; x++) {
                if(y % 2 != 0) {
                    if(x % 2 != 0) {
                        g.setColor(Color.WHITE);
                    }
                    else {
                        g.setColor(Color.BLACK);
                    }
                } else {
                    if(x % 2 != 0) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.WHITE);
                    }
                }
                g.fillRect(x*unitsize_x, y*unitsize_y, unitsize_x, unitsize_y);
            }
        }


        g.setColor(Color.red);
        for(Piece p : this.allPiece) {
            Board.drawPiece(g, p);
        }

        for(Position p : this.highlightsMoss) {
            Board.highlightsMoss(g, p);
        }
    }

    public void FillLegalMoss() {
        for(Piece piece : this.allPiece) {
            piece.setLegalMoss();
        }
    }

    public void addhighlightsMoss(Position p) {
        this.highlightsMoss.add(p);
        repaint();
    }

    public void clearhighlightsMoss() {
        this.highlightsMoss.clear();
        repaint();
    }


    public List<Piece> getAllPiece() {
        return this.allPiece;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
