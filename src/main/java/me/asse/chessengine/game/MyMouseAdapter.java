package me.asse.chessengine.game;

import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.material.PawnBlack;
import me.asse.chessengine.game.pieces.material.PawnWhite;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseAdapter extends MouseAdapter {

     @Override
     public void mouseClicked(MouseEvent e) {
         Position position;
         try {
             position = new Location(e.getX(), e.getY()).getPosition();
         } catch(Exception exception) {
             return;
         }
         Piece piece = position.getPiece();
         boolean mossCaptured = false;

        if(GameFrame.getGamePanel().selectedPiece != null) {
            if(GameFrame.getGamePanel().selectedPiece.getLegalMoss().contains(position)) {
                if(GameFrame.getGamePanel().selectedPiece instanceof PawnWhite || GameFrame.getGamePanel().selectedPiece instanceof PawnBlack) {
                    if(GameFrame.getGamePanel().selectedPiece instanceof PawnWhite) {
                        PawnWhite pawnWhite = (PawnWhite) GameFrame.getGamePanel().selectedPiece;
                        if(pawnWhite.getCaptureMoss().contains(position)) {
                            GameFrame.getGamePanel().removePiece(piece);
                            mossCaptured = true;
                        }
                    } else {
                        PawnBlack pawnBlack = (PawnBlack) GameFrame.getGamePanel().selectedPiece;
                        if(pawnBlack.getCaptureMoss().contains(position)) {
                            GameFrame.getGamePanel().removePiece(piece);
                            mossCaptured = true;
                        }
                    }
                } else {
                    if (piece != null) {
                        GameFrame.getGamePanel().removePiece(piece);
                        mossCaptured = true;
                    }
                }
               for(Piece this_piece : GameFrame.getGamePanel().getAllPiece()) {
                   if(this_piece == GameFrame.getGamePanel().selectedPiece) {
                       this_piece.setPosition(position);
                       GameFrame.getGamePanel().selectedPiece = null;
                       GameFrame.getGamePanel().FillLegalMoss();
                       GameFrame.getGamePanel().clearhighlightsMoss();
                   }
               }
            }


        }

        if(piece != null && !mossCaptured) {
            GameFrame.getGamePanel().selectedPiece = piece;
            GameFrame.getGamePanel().FillLegalMoss();
            GameFrame.getGamePanel().clearhighlightsMoss();
            for (Position this_position : piece.getLegalMoss()) {
                GameFrame.getGamePanel().addhighlightsMoss(this_position);
            }
        }

     }
}
