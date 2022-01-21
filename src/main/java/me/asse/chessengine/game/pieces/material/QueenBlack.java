package me.asse.chessengine.game.pieces.material;

import me.asse.chessengine.game.Board;
import me.asse.chessengine.game.Position;
import me.asse.chessengine.game.pieces.BlackPiece;
import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.WhitePiece;

import java.awt.image.BufferedImage;

public class QueenBlack extends BlackPiece {

    public QueenBlack(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }

    @Override
    public void setLegalMoss() {
        this.legalMoss.clear();
        int MatrixX = this.position.getMatrixX();
        int MatrixY = this.position.getMatrixY();

        Piece[][] pieces = Board.initBoard();

        for(int x = 1; x<8; x++) {
            if(MatrixX + x > 7) {
                break;
            }

            if(pieces[MatrixX + x][MatrixY] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX + x, MatrixY));
            } else {
                if(pieces[MatrixX + x][MatrixY] instanceof BlackPiece) {
                    break;
                } else if(pieces[MatrixX + x][MatrixY] instanceof WhitePiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX + x, MatrixY));
                    break;
                }
            }
        }

        for(int y = 1; y<8; y++) {
            if(MatrixY + y > 7) {
                break;
            }

            if(pieces[MatrixX][MatrixY+y] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX, MatrixY + y));
            } else {
                if(pieces[MatrixX][MatrixY + y] instanceof BlackPiece) {
                    break;
                } else if(pieces[MatrixX][MatrixY + y] instanceof WhitePiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX, MatrixY + y));
                    break;
                }
            }
        }

        for(int x = 1; x<8; x++) {
            if(MatrixX - x < 0) {
                break;
            }

            if(pieces[MatrixX - x][MatrixY] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX - x, MatrixY));
            } else {
                if(pieces[MatrixX - x][MatrixY] instanceof BlackPiece) {
                    break;
                } else if(pieces[MatrixX - x][MatrixY] instanceof WhitePiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX - x, MatrixY));
                    break;
                }
            }
        }

        for(int y = 1; y<8; y++) {
            if(MatrixY - y < 0) {
                break;
            }

            if(pieces[MatrixX][MatrixY-y] == null) {
                this.legalMoss.add(Board.getPosition(MatrixX, MatrixY - y));
            } else {
                if(pieces[MatrixX][MatrixY - y] instanceof BlackPiece) {
                    break;
                } else if(pieces[MatrixX][MatrixY - y] instanceof WhitePiece) {
                    this.legalMoss.add(Board.getPosition(MatrixX, MatrixY - y));
                    break;
                }
            }
        }

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
