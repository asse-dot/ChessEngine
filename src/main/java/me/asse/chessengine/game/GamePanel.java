package me.asse.chessengine.game;

import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.material.*;

import javax.swing.*;
import javax.swing.Timer;
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
    public final static int DELAY = 60;

    Timer timer;
    public Piece selectedPiece;

    public List<Position> highlightsMoss = new ArrayList();

    private List<Piece> allPiece = new ArrayList();



    public GamePanel() {
        this.setPreferredSize(new Dimension(dimension_x, dimension_y));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addMouseListener(new MyMouseAdapter());
        timer = new Timer(DELAY, this);
        timer.start();
        this.startGame();

    }

    public void startGame() {
        this.allPiece.add(new RookBlack(null, Position.a8, 5));
        this.allPiece.add(new RookBlack(null, Position.h8, 5));
        this.allPiece.add(new BisShopBlack(null, Position.c8, 3));
        this.allPiece.add(new BisShopBlack(null, Position.f8, 3));
        this.allPiece.add(new KnightBlack(null, Position.b8, 3));
        this.allPiece.add(new KnightBlack(null, Position.g8, 3));
        this.allPiece.add(new QueenBlack(null, Position.d8, 9));
        this.allPiece.add(new KingBlack(null, Position.e8, Integer.MAX_VALUE));
        this.allPiece.add(new PawnBlack(null, Position.f7, 1));

        this.allPiece.add(new RookWhite(null, Position.a1, 5));
        this.allPiece.add(new RookWhite(null, Position.h1, 5));
        this.allPiece.add(new BisShopWhite(null, Position.c1, 3));
        this.allPiece.add(new BisShopWhite(null, Position.f1, 3));
        this.allPiece.add(new KnightWhite(null, Position.b1, 3));
        this.allPiece.add(new KnightWhite(null, Position.g1, 3));
        this.allPiece.add(new QueenWhite(null, Position.d1, 9));
        this.allPiece.add(new KingWhite(null, Position.e1, Integer.MAX_VALUE));


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.draw(g);
    }

    public void draw(Graphics g) {

        Board.drawBoard(g, unitsize_x, unitsize_y);

        g.setColor(Color.red);
        for(Piece p : this.allPiece) {
            Board.drawPiece(g, p, unitsize_x, unitsize_y);
        }

        for(Position p : this.highlightsMoss) {
            Board.highlightsMoss(g, p, unitsize_x, unitsize_y);
        }

        promotePawnWhite(Board.getPawnWhiteToPromote());
        promotePawnBlack(Board.getPawnBlackToPromote());
    }

    public void createLegalMoss(Piece piece) {
        Piece[][] pieces = Board.initBoard();
        piece.setLegalMoss(pieces, false);
    }

    public void removePiece(Piece piece) {
        this.allPiece.remove(piece);
    }

    public void promotePawnWhite(PawnWhite pawn) {
        if(pawn == null) {
            return;
        }
        removePiece(pawn);
        this.allPiece.add(new QueenWhite(null, pawn.getPosition(), 9));
    }

    public void promotePawnBlack(PawnBlack pawn) {
        if(pawn == null)  {
            return;
        }
        removePiece(pawn);
        this.allPiece.add(new QueenBlack(null, pawn.getPosition(), 9));
    }

    public void addhighlightsMoss(Position p) {
        this.highlightsMoss.add(p);
    }

    public void clearhighlightsMoss() {
        this.highlightsMoss.clear();
    }


    public List<Piece> getAllPiece() {
        return this.allPiece;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
