package me.asse.chessengine.game.pieces;

import me.asse.chessengine.game.Position;

import java.awt.image.BufferedImage;

public abstract class WhitePiece extends Piece{

    private static int totalPoint = 0;

    public WhitePiece(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }

    public static void addPoint(int point) {
        totalPoint = totalPoint + point;
    }

}
