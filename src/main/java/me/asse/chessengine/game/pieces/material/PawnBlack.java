package me.asse.chessengine.game.pieces.material;

import me.asse.chessengine.game.Board;
import me.asse.chessengine.game.Position;
import me.asse.chessengine.game.pieces.BlackPiece;
import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.WhitePiece;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class PawnBlack extends BlackPiece {

    private List<Position> captureMoss = new ArrayList();

    public PawnBlack(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }


    @Override
    public void setLegalMoss(Piece[][] pieces) {
        this.legalMoss.clear();
        int MatrixX = this.position.getMatrixX();
        int MatrixY = this.position.getMatrixY();


        if(MatrixY - 1 >= 0) {
            if(pieces[MatrixX][MatrixY - 1] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX, MatrixY - 1));
            }
        }

        if(MatrixX + 1 < 8 && MatrixY - 1 >= 0) {
            if(pieces[MatrixX + 1][MatrixY - 1] != null && pieces[MatrixX + 1][MatrixY - 1] instanceof WhitePiece) {
                this.legalMoss.add(Board.getPosition(MatrixX + 1, MatrixY - 1));
                this.captureMoss.add(Board.getPosition(MatrixX + 1, MatrixY - 1));
            }
        }

        if(MatrixX - 1 >= 0 && MatrixY - 1 >= 0) {
            if(pieces[MatrixX - 1][MatrixY - 1] != null && pieces[MatrixX - 1][MatrixY - 1] instanceof WhitePiece) {
                this.legalMoss.add(Board.getPosition(MatrixX - 1, MatrixY - 1));
                this.captureMoss.add(Board.getPosition(MatrixX - 1, MatrixY - 1));
            }
        }

        if(MatrixY == 6) {
            if(pieces[MatrixX][MatrixY - 2] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX, MatrixY - 2));
            }
        }
    }

    public List<Position> getCaptureMoss() {
        return this.captureMoss;
    }
}
