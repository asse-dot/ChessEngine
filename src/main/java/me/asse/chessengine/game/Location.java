package me.asse.chessengine.game;

public class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Position getPosition() {
        for(Position position : Position.values()) {
            int MatrixX = position.getMatrixX();
            int MatrixY = position.getMatrixY();

            if(this.x >= MatrixX * 75 && this.x  <= (MatrixX + 1) * 75) {
                if(this.y <= 600 - MatrixY * 75 && this.y >= 600 - (MatrixY + 1) * 75) {
                    return position;
                }
            }
        }
        return null;
    }
}
