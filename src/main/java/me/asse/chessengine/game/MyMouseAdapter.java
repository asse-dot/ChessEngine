package me.asse.chessengine.game;

import me.asse.chessengine.game.pieces.Piece;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseAdapter extends MouseAdapter {

     @Override
     public void mouseClicked(MouseEvent e) {
         Position position = new Location(e.getX(), e.getY()).getPosition();
        Piece piece = position.getPiece();

        if(GameFrame.getGamePanel().selectedPiece != null) {
            if(GameFrame.getGamePanel().selectedPiece.getLegalMoss().contains(position)) {
               for(Piece this_piece : GameFrame.getGamePanel().getAllPiece()) {
                   if(this_piece == GameFrame.getGamePanel().selectedPiece) {
                       this_piece.setPosition(position);
                   }
               }
            }
        }

        if(piece != null) {
            GameFrame.getGamePanel().selectedPiece = piece;
            GameFrame.getGamePanel().clearhighlightsMoss();
            GameFrame.getGamePanel().FillLegalMoss();
            for (Position this_position : piece.getLegalMoss()) {
                GameFrame.getGamePanel().addhighlightsMoss(this_position);
            }
        }

     }
}
