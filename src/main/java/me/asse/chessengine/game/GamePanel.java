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

    public Graphics g;
    private List<Piece> allPiece = new ArrayList();



    public GamePanel() {
        this.setPreferredSize(new Dimension(dimension_x, dimension_y));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.startGame();
        this.addMouseListener(new MyMouseAdapter());
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void startGame() {
        this.allPiece.add(new RookWhite(null, Position.a1, 5));
        this.allPiece.add(new RookWhite(null, Position.h1, 5));
        this.allPiece.add(new KnightWhite(null, Position.b1, 3));
        this.allPiece.add(new KnightWhite(null, Position.g1, 3));
        this.allPiece.add(new BisShopWhite(null, Position.c1, 3));
        this.allPiece.add(new BisShopWhite(null, Position.f1, 3));
        this.allPiece.add(new QueenWhite(null, Position.d1, 9));
        this.allPiece.add(new PawnWhite(null, Position.a2, 1));
        this.allPiece.add(new PawnWhite(null, Position.b2, 1));
        this.allPiece.add(new PawnWhite(null, Position.c2, 1));
        this.allPiece.add(new PawnWhite(null, Position.d2, 1));
        this.allPiece.add(new PawnWhite(null, Position.e2, 1));
        this.allPiece.add(new PawnWhite(null, Position.f2, 1));
        this.allPiece.add(new PawnWhite(null, Position.g2, 1));
        this.allPiece.add(new PawnWhite(null, Position.h2, 1));

        this.allPiece.add(new RookBlack(null, Position.a8, 5));
        this.allPiece.add(new RookBlack(null, Position.h8, 5));
        this.allPiece.add(new KnightBlack(null, Position.b8, 3));
        this.allPiece.add(new KnightBlack(null, Position.g8, 3));
        this.allPiece.add(new BisShopBlack(null, Position.c8, 3));
        this.allPiece.add(new BisShopBlack(null, Position.f8, 3));
        this.allPiece.add(new QueenBlack(null, Position.d8, 9));
        this.allPiece.add(new PawnBlack(null, Position.a7, 1));
        this.allPiece.add(new PawnBlack(null, Position.b7, 1));
        this.allPiece.add(new PawnBlack(null, Position.c7, 1));
        this.allPiece.add(new PawnBlack(null, Position.d7, 1));
        this.allPiece.add(new PawnBlack(null, Position.e7, 1));
        this.allPiece.add(new PawnBlack(null, Position.f7, 1));
        this.allPiece.add(new PawnBlack(null, Position.g7, 1));
        this.allPiece.add(new PawnBlack(null, Position.h7, 1));

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

        PawnWhite pawn_white_promote = null;
        PawnBlack pawn_black_promote = null;
        g.setColor(Color.red);
        for(Piece p : this.allPiece) {
            if(p instanceof PawnWhite) {
                PawnWhite pawnWhite = (PawnWhite) p;
                if(p.getPosition().getMatrixY() == 7) {
                    pawn_white_promote = pawnWhite;
                }
            } else if(p instanceof PawnBlack) {
                PawnBlack pawnBlack = (PawnBlack) p;
                if(p.getPosition().getMatrixY() == 0) {
                    pawn_black_promote = pawnBlack;
                }
            }
            Board.drawPiece(g, p);
        }
        promotePawnWhite(pawn_white_promote);

        for(Position p : this.highlightsMoss) {
            Board.highlightsMoss(g, p);
        }
    }

    public void FillLegalMoss() {
        for(Piece piece : this.allPiece) {
            piece.setLegalMoss();
        }
    }

    public void removePiece(Piece piece) {
        this.allPiece.remove(piece);
    }

    public void promotePawnWhite(PawnWhite pawn) {
        if(pawn == null) {
            return;
        }
        removePiece(pawn);
        this.allPiece.add(new QueenWhite(null, pawn.getPosition(), 5));
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
