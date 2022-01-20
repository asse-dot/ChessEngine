package me.asse.chessengine.game.pieces.material;

import me.asse.chessengine.game.Board;
import me.asse.chessengine.game.Position;
import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.WhitePiece;

import java.awt.image.BufferedImage;

public class PawnWhite extends WhitePiece {

    public PawnWhite(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }

    @Override
    public void setLegalMoss() {
        this.legalMoss.clear();
        int MatrixX = this.position.getMatrixX();
        int MatrixY = this.position.getMatrixY();

        Piece[][] pieces = Board.initBoard();

        if(pieces[MatrixX][MatrixY + 1] == null) {
            this.legalMoss.add(Board.getPosition(MatrixX, MatrixY + 1));
        }

    }
}
