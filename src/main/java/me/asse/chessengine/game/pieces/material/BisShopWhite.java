package me.asse.chessengine.game.pieces.material;

import me.asse.chessengine.game.Board;
import me.asse.chessengine.game.Position;
import me.asse.chessengine.game.pieces.BlackPiece;
import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.WhitePiece;

import java.awt.image.BufferedImage;

public class BisShopWhite extends WhitePiece {

    public BisShopWhite(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }


    @Override
    public void setLegalMoss(Piece[][] pieces, boolean isChecking) {
        this.legalMoss.clear();
        int MatrixX = this.position.getMatrixX();
        int MatrixY = this.position.getMatrixY();

        for(int n = 1; n < 8; n++) {
            if(MatrixX + n > 7 || MatrixY + n > 7) {
                break;
            }

            if(!isChecking) {
                if (Board.isIllegalMove(pieces, this, n, n)) {
                    continue;
                }
            }
            if(pieces[MatrixX + n][MatrixY + n] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX + n, MatrixY + n));
            } else {
                if(pieces[MatrixX + n][MatrixY + n] instanceof WhitePiece) {
                    break;
                } else if(pieces[MatrixX + n][MatrixY + n] instanceof BlackPiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX + n, MatrixY+n));
                    break;
                }
            }
        }
        for(int n = 1; n<8; n++) {
            if(MatrixX - n < 0 || MatrixY + n > 7) {
                break;
            }

            if(!isChecking) {
                if (Board.isIllegalMove(pieces, this, -n, n)) {
                    continue;
                }
            }
            if(pieces[MatrixX - n][MatrixY + n] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX - n, MatrixY + n));
            } else {
                if(pieces[MatrixX - n][MatrixY + n] instanceof WhitePiece) {
                    break;
                } else if(pieces[MatrixX-n][MatrixY + n] instanceof BlackPiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX - n, MatrixY + n));
                    break;
                }
            }
        }
        for(int n = 1; n<8; n++) {
            if(MatrixX - n < 0 || MatrixY - n < 0) {
                break;
            }

            if(!isChecking) {
                if (Board.isIllegalMove(pieces, this, -n, -n)) {
                    continue;
                }
            }
            if(pieces[MatrixX - n][MatrixY - n] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX - n, MatrixY - n));
            } else {
                if(pieces[MatrixX - n][MatrixY - n] instanceof WhitePiece) {
                    break;
                } else if(pieces[MatrixX - n][MatrixY - n] instanceof BlackPiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX - n, MatrixY - n));
                    break;
                }
            }
        }
        for(int n = 1; n<8; n++) {
            if(MatrixX + n > 7 || MatrixY - n < 0) {
                break;
            }

            if(!isChecking) {
                if (Board.isIllegalMove(pieces, this, n, -n)) {
                    continue;
                }
            }
            if(pieces[MatrixX + n][MatrixY - n] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX + n, MatrixY - n));
            } else {
                if(pieces[MatrixX + n][MatrixY - n] instanceof WhitePiece) {
                    break;
                } else if(pieces[MatrixX + n][MatrixY - n] instanceof BlackPiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX + n, MatrixY - n));
                    break;
                }
            }
        }

    }
}
