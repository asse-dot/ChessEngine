package me.asse.chessengine.game.pieces.material;

import me.asse.chessengine.game.Board;
import me.asse.chessengine.game.Position;
import me.asse.chessengine.game.pieces.BlackPiece;
import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.WhitePiece;

import java.awt.image.BufferedImage;

public class QueenWhite extends WhitePiece {

    public QueenWhite(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }


    @Override
    public void setLegalMoss(Piece[][] pieces, boolean isChecking) {
        this.legalMoss.clear();
        int MatrixX = this.position.getMatrixX();
        int MatrixY = this.position.getMatrixY();


        for(int x = 1; x<8; x++) {
            if(MatrixX + x > 7) {
                break;
            }

            if(!isChecking) {
                if (Board.isIllegalMove(pieces, this, x, 0)) {
                    continue;
                }
            }

            if(pieces[MatrixX + x][MatrixY] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX + x, MatrixY));
            } else {
                if(pieces[MatrixX + x][MatrixY] instanceof WhitePiece) {
                    break;
                } else if(pieces[MatrixX + x][MatrixY] instanceof BlackPiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX + x, MatrixY));
                    break;
                }
            }
        }

        for(int y = 1; y<8; y++) {
            if(MatrixY + y > 7) {
                break;
            }

            if(!isChecking) {
                if (Board.isIllegalMove(pieces, this, 0, y)) {
                    continue;
                }
            }

            if(pieces[MatrixX][MatrixY+y] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX, MatrixY + y));
            } else {
                if(pieces[MatrixX][MatrixY + y] instanceof WhitePiece) {
                    break;
                } else if(pieces[MatrixX][MatrixY + y] instanceof BlackPiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX, MatrixY + y));
                    break;
                }
            }
        }

        for(int x = 1; x<8; x++) {
            if(MatrixX - x < 0) {
                break;
            }

            if(!isChecking) {
                if (Board.isIllegalMove(pieces, this, -x, 0)) {
                    continue;
                }
            }

            if(pieces[MatrixX - x][MatrixY] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX - x, MatrixY));
            } else {
                if(pieces[MatrixX - x][MatrixY] instanceof WhitePiece) {
                    break;
                } else if(pieces[MatrixX - x][MatrixY] instanceof BlackPiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX - x, MatrixY));
                    break;
                }
            }
        }

        for(int y = 1; y<8; y++) {
            if(MatrixY - y < 0) {
                break;
            }

            if(!isChecking) {
                if (Board.isIllegalMove(pieces, this, 0, -y)) {
                    continue;
                }
            }

            if(pieces[MatrixX][MatrixY-y] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX, MatrixY - y));
            } else {
                if(pieces[MatrixX][MatrixY - y] instanceof WhitePiece) {
                    break;
                } else if(pieces[MatrixX][MatrixY - y] instanceof BlackPiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX, MatrixY - y));
                    break;
                }
            }
        }

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
