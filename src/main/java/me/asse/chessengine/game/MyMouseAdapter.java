package me.asse.chessengine.game;

import me.asse.chessengine.game.pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseAdapter extends MouseAdapter {

     @Override
     public void mouseClicked(MouseEvent e) {
        Location l = new Location(e.getX(), e.getY());
        Piece piece = l.getPosition().getPiece();

        if(piece != null) {
            GameFrame.getGamePanel().clearhighlightsMoss();
            GameFrame.getGamePanel().FillLegalMoss();
            for (Position position : piece.getLegalMoss()) {
                GameFrame.getGamePanel().addhighlightsMoss(position);
            }
        }

     }
}
