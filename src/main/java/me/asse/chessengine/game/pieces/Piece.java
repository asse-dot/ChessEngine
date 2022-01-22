package me.asse.chessengine.game.pieces;

import me.asse.chessengine.game.GameFrame;
import me.asse.chessengine.game.Position;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    protected BufferedImage img;
    protected Position position;
    protected List<Position> legalMoss = new ArrayList<Position>();
    protected int point;

    public Piece(BufferedImage img, Position initial_position, int point) {
        this.img = img;
        this.position = initial_position;
        this.point = point;
    }

    public abstract void setLegalMoss(Piece[][] pieces);

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public List<Position> getLegalMoss() {
        return this.legalMoss;
    }

    public int getPoint() {
        return this.point;
    }


}
