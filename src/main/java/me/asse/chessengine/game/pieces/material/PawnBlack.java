package me.asse.chessengine.game.pieces.material;

import me.asse.chessengine.game.Position;
import me.asse.chessengine.game.pieces.BlackPiece;

import java.awt.image.BufferedImage;

public class PawnBlack extends BlackPiece {

    public PawnBlack(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }

    @Override
    public void setLegalMoss() {
        this.legalMoss.clear();
    }
}
