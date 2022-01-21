package me.asse.chessengine.game.pieces.material;

import me.asse.chessengine.game.Board;
import me.asse.chessengine.game.Position;
import me.asse.chessengine.game.pieces.BlackPiece;
import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.WhitePiece;

import java.awt.image.BufferedImage;

public class BisShopBlack extends BlackPiece {

    public BisShopBlack(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }

    @Override
    public void setLegalMoss() {
        this.legalMoss.clear();
        int MatrixX = this.position.getMatrixX();
        int MatrixY = this.position.getMatrixY();

        Piece[][] pieces = Board.initBoard();

        for(int n = 1; n < 8; n++) {
            if(MatrixX + n > 7 || MatrixY + n > 7) {
                break;
            }

            if(pieces[MatrixX + n][MatrixY + n] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX + n, MatrixY + n));
            } else {
                if(pieces[MatrixX + n][MatrixY + n] instanceof BlackPiece) {
                    break;
                } else if(pieces[MatrixX + n][MatrixY + n] instanceof WhitePiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX + n, MatrixY+n));
                    break;
                }
            }
        }

        for(int n = 1; n<8; n++) {
            if(MatrixX - n < 0 || MatrixY + n > 7) {
                break;
            }

            if(pieces[MatrixX - n][MatrixY + n] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX - n, MatrixY + n));
            } else {
                if(pieces[MatrixX - n][MatrixY + n] instanceof BlackPiece) {
                    break;
                } else if(pieces[MatrixX-n][MatrixY + n] instanceof WhitePiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX - n, MatrixY + n));
                    break;
                }
            }
        }

        for(int n = 1; n<8; n++) {
            if(MatrixX - n < 0 || MatrixY - n < 0) {
                break;
            }

            if(pieces[MatrixX - n][MatrixY - n] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX - n, MatrixY - n));
            } else {
                if(pieces[MatrixX - n][MatrixY - n] instanceof BlackPiece) {
                    break;
                } else if(pieces[MatrixX - n][MatrixY - n] instanceof WhitePiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX - n, MatrixY - n));
                    break;
                }
            }
        }

        for(int n = 1; n<8; n++) {
            if(MatrixX + n > 7 || MatrixY - n < 0) {
                break;
            }

            if(pieces[MatrixX + n][MatrixY - n] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX + n, MatrixY - n));
            } else {
                if(pieces[MatrixX + n][MatrixY - n] instanceof BlackPiece) {
                    break;
                } else if(pieces[MatrixX + n][MatrixY - n] instanceof WhitePiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX + n, MatrixY - n));
                    break;
                }
            }
        }

    }
}
