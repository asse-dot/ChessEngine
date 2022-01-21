package me.asse.chessengine.game.pieces.material;

import me.asse.chessengine.game.Position;
import me.asse.chessengine.game.pieces.WhitePiece;

import java.awt.image.BufferedImage;

public class KingWhite extends WhitePiece {

    public KingWhite(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }

    @Override
    public void setLegalMoss() {

    }
}
