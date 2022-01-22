package me.asse.chessengine.game.pieces.material;

import me.asse.chessengine.game.Board;
import me.asse.chessengine.game.Position;
import me.asse.chessengine.game.pieces.BlackPiece;
import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.WhitePiece;

import java.awt.image.BufferedImage;

public class KnightWhite extends WhitePiece {

    public KnightWhite(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }


    @Override
    public void setLegalMoss(Piece[][] pieces) {
        this.legalMoss.clear();
        int MatrixX = this.position.getMatrixX();
        int MatrixY = this.position.getMatrixY();

        if (MatrixX + 1 < 8 && MatrixY + 2 < 8) {
            if (pieces[MatrixX + 1][MatrixY + 2] == null || (pieces[MatrixX + 1][MatrixY + 2] != null && pieces[MatrixX + 1][MatrixY + 2] instanceof BlackPiece)) {
                this.legalMoss.add(Board.getPosition(MatrixX + 1, MatrixY + 2));
            }
        }

        if (MatrixX - 1 >= 0 && MatrixY + 2 < 8) {
            if (pieces[MatrixX - 1][MatrixY + 2] == null || (pieces[MatrixX - 1][MatrixY + 2] != null && pieces[MatrixX - 1][MatrixY + 2] instanceof BlackPiece)) {
                this.legalMoss.add(Board.getPosition(MatrixX - 1, MatrixY + 2));
            }
        }

        if (MatrixX + 1 < 8 && MatrixY - 2 >= 0) {
            if (pieces[MatrixX + 1][MatrixY - 2] == null || (pieces[MatrixX + 1][MatrixY - 2] != null && pieces[MatrixX + 1][MatrixY - 2] instanceof BlackPiece)) {
                this.legalMoss.add(Board.getPosition(MatrixX + 1, MatrixY - 2));
            }
        }

        if(MatrixX - 1 >= 0 && MatrixY - 2 >= 0) {
            if (pieces[MatrixX - 1][MatrixY - 2] == null || (pieces[MatrixX - 1][MatrixY - 2] != null && pieces[MatrixX - 1][MatrixY - 2] instanceof BlackPiece)) {
                this.legalMoss.add(Board.getPosition(MatrixX - 1, MatrixY - 2));
            }
        }

        if(MatrixX + 2 < 8 && MatrixY + 1 < 8) {
            if (pieces[MatrixX + 2][MatrixY + 1] == null || (pieces[MatrixX + 2][MatrixY + 1] != null && pieces[MatrixX + 2][MatrixY + 1] instanceof BlackPiece)) {
                this.legalMoss.add(Board.getPosition(MatrixX + 2, MatrixY + 1));
            }
        }

        if(MatrixX - 2 >= 0 && MatrixY + 1 < 8) {
            if (pieces[MatrixX - 2][MatrixY + 1] == null || (pieces[MatrixX - 2][MatrixY + 1] != null && pieces[MatrixX - 2][MatrixY + 1] instanceof BlackPiece)) {
                this.legalMoss.add(Board.getPosition(MatrixX - 2, MatrixY + 1));
            }
        }

        if(MatrixX + 2 < 8 && MatrixY - 1 >= 0) {
            if (pieces[MatrixX + 2][MatrixY - 1] == null || (pieces[MatrixX + 2][MatrixY - 1] != null && pieces[MatrixX + 2][MatrixY - 1] instanceof BlackPiece)) {
                this.legalMoss.add(Board.getPosition(MatrixX + 2, MatrixY - 1));
            }
        }

        if(MatrixX - 2 >= 0 && MatrixY - 1 >= 0) {
            if (pieces[MatrixX - 2][MatrixY - 1] == null || (pieces[MatrixX - 2][MatrixY - 1] != null && pieces[MatrixX - 2][MatrixY - 1] instanceof BlackPiece)) {
                this.legalMoss.add(Board.getPosition(MatrixX - 2, MatrixY - 1));
            }
        }
    }
}
