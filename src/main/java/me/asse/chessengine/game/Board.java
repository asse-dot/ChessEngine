package me.asse.chessengine.game;

import me.asse.chessengine.game.pieces.Piece;

import java.awt.*;

public class Board {

    public static Position getPosition(int x, int y) {
        for(Position position : Position.values()) {
            if(position.getMatrixX() == x && position.getMatrixY() == y) {
                return position;
            }
        }
        return null;
    }

    public static Piece[][] initBoard() {
        Piece[][] pieces = new Piece[65][65];
        for(Piece piece : GameFrame.getGamePanel().getAllPiece()) {
            pieces[piece.getPosition().getMatrixX()][piece.getPosition().getMatrixY()] = piece;
        }


        return pieces;
    }

    public static void drawPiece(Graphics g, Piece p) {
        g.fillOval(p.getPosition().getMatrixX() * 75, 600 - (p.getPosition().getMatrixY() + 1) * 75, 75, 75);
    }

    public static void highlightsMoss(Graphics g, Position p) {
        g.setColor(Color.GREEN);
        g.drawOval(p.getMatrixX() * 75, 600 - (p.getMatrixY() + 1) * 75, 75, 75);
    }


}
