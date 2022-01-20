package me.asse.chessengine.game.pieces;

import me.asse.chessengine.game.Position;
import me.asse.chessengine.game.pieces.Piece;

import java.awt.image.BufferedImage;

public abstract class BlackPiece extends Piece {

    private static int totalPoint = 0;

    public BlackPiece(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }

    public static void addPoint(int point) {
        totalPoint = totalPoint + point;
    }

}
