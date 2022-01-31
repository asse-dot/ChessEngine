package me.asse.chessengine.game.pieces.material;

import me.asse.chessengine.game.Board;
import me.asse.chessengine.game.Position;
import me.asse.chessengine.game.pieces.BlackPiece;
import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.WhitePiece;

import java.awt.image.BufferedImage;

public class KingBlack extends BlackPiece {

    public KingBlack(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }

    @Override
    public void setLegalMoss(Piece[][] pieces, boolean isChecking) {
        this.legalMoss.clear();
        int MatrixX = this.position.getMatrixX();
        int MatrixY = this.position.getMatrixY();

        if (!isChecking) {
            if (MatrixX + 1 < 8) {
                if (!(pieces[MatrixX + 1][MatrixY] != null && pieces[MatrixX + 1][MatrixY] instanceof BlackPiece)) {
                    if (!Board.isIllegalMove(pieces, this, 1, 0)) {
                        this.legalMoss.add(Board.getPosition(MatrixX + 1, MatrixY));
                    }
                }
            }

            if (MatrixX - 1 >= 0) {
                if (!(pieces[MatrixX - 1][MatrixY] != null && pieces[MatrixX - 1][MatrixY] instanceof BlackPiece)) {
                    if (!Board.isIllegalMove(pieces, this, -1, 0)) {
                        this.legalMoss.add(Board.getPosition(MatrixX - 1, MatrixY));
                    }
                }
            }

            if (MatrixY + 1 < 8) {
                if (!(pieces[MatrixX][MatrixY + 1] != null && pieces[MatrixX][MatrixY + 1] instanceof BlackPiece)) {
                    if (!Board.isIllegalMove(pieces, this, 0, 1)) {
                        this.legalMoss.add(Board.getPosition(MatrixX, MatrixY + 1));
                    }
                }
            }

            if (MatrixY - 1 >= 0) {
                if (!(pieces[MatrixX][MatrixY - 1] != null && pieces[MatrixX][MatrixY - 1] instanceof BlackPiece)) {
                    if (!Board.isIllegalMove(pieces, this, 0, -1)) {
                        this.legalMoss.add(Board.getPosition(MatrixX, MatrixY - 1));
                    }
                }
            }

            if (MatrixX + 1 < 8 && MatrixY + 1 < 8) {
                if (!(pieces[MatrixX + 1][MatrixY + 1] != null && pieces[MatrixX + 1][MatrixY + 1] instanceof BlackPiece)) {
                    if (!Board.isIllegalMove(pieces, this, 1, 1)) {
                        this.legalMoss.add(Board.getPosition(MatrixX + 1, MatrixY + 1));
                    }
                }
            }

            if (MatrixX - 1  >= 0 && MatrixY - 1 >= 0) {
                if (!(pieces[MatrixX - 1][MatrixY - 1] != null && pieces[MatrixX - 1][MatrixY - 1] instanceof BlackPiece)) {
                    if (!Board.isIllegalMove(pieces, this, -1, -1)) {
                        this.legalMoss.add(Board.getPosition(MatrixX - 1, MatrixY - 1));
                    }
                }
            }

            if (MatrixX - 1  >= 0 && MatrixY + 1 < 8) {
                if (!(pieces[MatrixX - 1][MatrixY + 1] != null && pieces[MatrixX - 1][MatrixY + 1] instanceof BlackPiece)) {
                    if (!Board.isIllegalMove(pieces, this, -1, 1)) {
                        this.legalMoss.add(Board.getPosition(MatrixX - 1, MatrixY + 1));
                    }
                }
            }

            if (MatrixX + 1  < 8 && MatrixY - 1 >=  0) {
                if (!(pieces[MatrixX + 1][MatrixY - 1] != null && pieces[MatrixX + 1][MatrixY - 1] instanceof BlackPiece)) {
                    if (!Board.isIllegalMove(pieces, this, 1, -1)) {
                        this.legalMoss.add(Board.getPosition(MatrixX + 1, MatrixY - 1));
                    }
                }
            }
        } else {
            if (MatrixX + 1 < 8) {
                if (!(pieces[MatrixX + 1][MatrixY] != null && pieces[MatrixX + 1][MatrixY] instanceof BlackPiece)) {
                    this.legalMoss.add(Board.getPosition(MatrixX + 1, MatrixY));
                }
            }

            if (MatrixX - 1 >= 0) {
                if (!(pieces[MatrixX - 1][MatrixY] != null && pieces[MatrixX - 1][MatrixY] instanceof BlackPiece)) {
                    this.legalMoss.add(Board.getPosition(MatrixX + 1, MatrixY));
                }
            }

            if (MatrixY + 1 < 8) {
                if (!(pieces[MatrixX][MatrixY + 1] != null && pieces[MatrixX][MatrixY + 1] instanceof BlackPiece)) {
                    this.legalMoss.add(Board.getPosition(MatrixX, MatrixY + 1));
                }
            }

            if (MatrixY - 1 >= 0) {
                if (!(pieces[MatrixX][MatrixY - 1] != null && pieces[MatrixX][MatrixY - 1] instanceof BlackPiece)) {
                    this.legalMoss.add(Board.getPosition(MatrixX, MatrixY - 1));
                }
            }

            if (MatrixX + 1 < 8 && MatrixY + 1 < 8) {
                if (!(pieces[MatrixX + 1][MatrixY + 1] != null && pieces[MatrixX + 1][MatrixY + 1] instanceof BlackPiece)) {
                    this.legalMoss.add(Board.getPosition(MatrixX + 1, MatrixY + 1));
                }
            }

            if (MatrixX - 1  >= 0 && MatrixY - 1 >= 0) {
                if (!(pieces[MatrixX - 1][MatrixY - 1] != null && pieces[MatrixX - 1][MatrixY - 1] instanceof BlackPiece)) {
                    this.legalMoss.add(Board.getPosition(MatrixX - 1, MatrixY - 1));
                }
            }

            if (MatrixX - 1  >= 0 && MatrixY + 1 < 8) {
                if (!(pieces[MatrixX - 1][MatrixY + 1] != null && pieces[MatrixX - 1][MatrixY + 1] instanceof BlackPiece)) {
                    this.legalMoss.add(Board.getPosition(MatrixX - 1, MatrixY + 1));
                }
            }

            if (MatrixX + 1  < 8 && MatrixY - 1 >=  0) {
                if (!(pieces[MatrixX + 1][MatrixY - 1] != null && pieces[MatrixX + 1][MatrixY - 1] instanceof BlackPiece)) {
                    this.legalMoss.add(Board.getPosition(MatrixX + 1, MatrixY - 1));
                }
            }
        }
    }
}
