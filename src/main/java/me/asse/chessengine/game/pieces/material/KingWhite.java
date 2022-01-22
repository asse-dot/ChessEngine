package me.asse.chessengine.game.pieces.material;

import me.asse.chessengine.game.Board;
import me.asse.chessengine.game.GameFrame;
import me.asse.chessengine.game.Position;
import me.asse.chessengine.game.pieces.BlackPiece;
import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.WhitePiece;

import java.awt.image.BufferedImage;

public class KingWhite extends WhitePiece {

    public KingWhite(BufferedImage img, Position initial_position, int point) {
        super(img, initial_position, point);
    }


    @Override
    public void setLegalMoss(Piece[][] pieces) {
        this.legalMoss.clear();
        int MatrixX = this.position.getMatrixX();
        int MatrixY = this.position.getMatrixY();
        boolean passed = true;


        if(MatrixX + 1 < 8) {
            if(!(pieces[MatrixX + 1][MatrixY] != null && pieces[MatrixX + 1][MatrixY] instanceof WhitePiece)) {
                pieces[MatrixX][MatrixY + 1] = pieces[MatrixX][MatrixY];
                pieces[MatrixX][MatrixY] = null;
                for(Piece this_piece : GameFrame.getGamePanel().getAllPiece()) {
                    if(this_piece instanceof KingWhite) {
                        continue;
                    }

                    this_piece.setLegalMoss(pieces);
                }
                for (Piece piece : GameFrame.getGamePanel().getAllPiece()) {
                    if (piece instanceof BlackPiece) {
                        if (piece.getLegalMoss().contains(Board.getPosition(MatrixX + 1, MatrixY))) {
                            passed = false;
                            break;
                        }
                    }
                }

                if (passed) {
                    this.legalMoss.add(Board.getPosition(MatrixX + 1, MatrixY));
                }
                pieces = Board.initBoard();
            }
        }

        passed = true;
        if(MatrixX - 1 >= 0) {
            if(!(pieces[MatrixX - 1][MatrixY] != null && pieces[MatrixX - 1][MatrixY] instanceof WhitePiece)) {
                pieces[MatrixX][MatrixY + 1] = pieces[MatrixX][MatrixY];
                pieces[MatrixX][MatrixY] = null;
                for(Piece this_piece : GameFrame.getGamePanel().getAllPiece()) {
                    if(this_piece instanceof KingWhite) {
                        continue;
                    }

                    this_piece.setLegalMoss(pieces);
                }
                for (Piece piece : GameFrame.getGamePanel().getAllPiece()) {
                    if (piece instanceof BlackPiece) {
                        if (piece.getLegalMoss().contains(Board.getPosition(MatrixX - 1, MatrixY))) {
                            passed = false;
                            break;
                        }
                    }
                }

                if (passed) {
                    this.legalMoss.add(Board.getPosition(MatrixX - 1, MatrixY));
                }
                pieces = Board.initBoard();
            }
        }

        passed = true;
        if(MatrixY + 1 <  8) {
            if(!(pieces[MatrixX][MatrixY + 1] != null && pieces[MatrixX][MatrixY + 1] instanceof WhitePiece)) {
                pieces[MatrixX][MatrixY + 1] = pieces[MatrixX][MatrixY];
                pieces[MatrixX][MatrixY] = null;
                for(Piece this_piece : GameFrame.getGamePanel().getAllPiece()) {
                    if(this_piece instanceof KingWhite) {
                        continue;
                    }

                    this_piece.setLegalMoss(pieces);
                }
                for (Piece piece : GameFrame.getGamePanel().getAllPiece()) {
                    if (piece instanceof BlackPiece) {
                        if (piece.getLegalMoss().contains(Board.getPosition(MatrixX, MatrixY + 1))) {
                            passed = false;
                            break;
                        }
                    }
                }

                if (passed) {
                    this.legalMoss.add(Board.getPosition(MatrixX, MatrixY + 1));
                }

                pieces = Board.initBoard();
            }
        }

        passed = true;
        if(MatrixY - 1 >=  0) {
            if(!(pieces[MatrixX][MatrixY - 1] != null && pieces[MatrixX][MatrixY - 1] instanceof WhitePiece)) {
                pieces[MatrixX][MatrixY + 1] = pieces[MatrixX][MatrixY];
                pieces[MatrixX][MatrixY] = null;
                for(Piece this_piece : GameFrame.getGamePanel().getAllPiece()) {
                    if(this_piece instanceof KingWhite) {
                        continue;
                    }

                    this_piece.setLegalMoss(pieces);
                }
                for (Piece piece : GameFrame.getGamePanel().getAllPiece()) {
                    if (piece instanceof BlackPiece) {
                        if (piece.getLegalMoss().contains(Board.getPosition(MatrixX, MatrixY - 1))) {
                            passed = false;
                            break;
                        }
                    }
                }

                if (passed) {
                    this.legalMoss.add(Board.getPosition(MatrixX, MatrixY - 1));
                }
                pieces = Board.initBoard();
            }
        }
    }

}
