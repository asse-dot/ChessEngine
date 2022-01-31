package me.asse.chessengine.game;

import me.asse.chessengine.game.pieces.BlackPiece;
import me.asse.chessengine.game.pieces.Piece;
import me.asse.chessengine.game.pieces.WhitePiece;
import me.asse.chessengine.game.pieces.material.KingBlack;
import me.asse.chessengine.game.pieces.material.KingWhite;
import me.asse.chessengine.game.pieces.material.PawnBlack;
import me.asse.chessengine.game.pieces.material.PawnWhite;

import java.awt.*;

public class Board {

    public static GameStatus gameStatus;

    public static Position getPosition(int x, int y) {
        for (Position position : Position.values()) {
            if (position.getMatrixX() == x && position.getMatrixY() == y) {
                return position;
            }
        }
        return null;
    }



    public static Piece[][] initBoard() {
        Piece[][] pieces = new Piece[65][65];
        for (Piece piece : GameFrame.getGamePanel().getAllPiece()) {
            pieces[piece.getPosition().getMatrixX()][piece.getPosition().getMatrixY()] = piece;
        }


        return pieces;
    }

    public static void drawBoard(Graphics g, int unitsize_x, int unitsize_y) {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (y % 2 != 0) {
                    if (x % 2 != 0) {
                        g.setColor(Color.WHITE);
                    } else {
                        g.setColor(Color.BLACK);
                    }
                } else {
                    if (x % 2 != 0) {
                        g.setColor(Color.BLACK);
                    } else {
                        g.setColor(Color.WHITE);
                    }
                }
                g.fillRect(x * unitsize_x, y * unitsize_y, unitsize_x, unitsize_y);
            }
        }
    }


    public static void drawPiece(Graphics g, Piece p, int unitsize_x, int unitsize_y) {
        g.fillOval(p.getPosition().getMatrixX() * unitsize_x, 600 - (p.getPosition().getMatrixY() + 1) * unitsize_y, unitsize_x, unitsize_y);
    }

    public static void highlightsMoss(Graphics g, Position p, int unitsize_x, int unitsize_y) {
        g.setColor(Color.GREEN);
        g.drawOval(p.getMatrixX() * 75, 600 - (p.getMatrixY() + 1) * 75, 75, 75);
    }

    public static PawnWhite getPawnWhiteToPromote() {
        PawnWhite pawnWhite;
        for (Piece piece : GameFrame.getGamePanel().getAllPiece()) {
            if (piece instanceof PawnWhite) {
                pawnWhite = (PawnWhite) piece;
                if (pawnWhite.getPosition().getMatrixY() == 7) {
                    return pawnWhite;
                }
            }
        }
        return null;
    }

    public static PawnBlack getPawnBlackToPromote() {
        PawnBlack pawnBlack;
        for (Piece piece : GameFrame.getGamePanel().getAllPiece()) {
            if (piece instanceof PawnBlack) {
                pawnBlack = (PawnBlack) piece;
                if (pawnBlack.getPosition().getMatrixY() == 0) {
                    return pawnBlack;
                }
            }
        }
        return null;
    }

    public static boolean isIllegalMove(Piece[][] pieces, Piece piece, int x, int y) {
        int MatrixX = piece.getPosition().getMatrixX();
        int MatrixY = piece.getPosition().getMatrixY();
        Piece old_piece_on_board = pieces[MatrixX + x][MatrixY + y];

        pieces[MatrixX + x][MatrixY + y] = pieces[MatrixX][MatrixY];
        pieces[MatrixX][MatrixY] = null;

        if(piece instanceof KingWhite) {
            for(Piece valute_piece : GameFrame.getGamePanel().getAllPiece()) {
                if(valute_piece instanceof PawnBlack) {
                    PawnBlack pawnBlack = (PawnBlack) valute_piece;
                    pawnBlack.setLegalMoss(pieces, true);
                    for(Position p : pawnBlack.getCaptureMoss()) {
                        if(pieces[p.getMatrixX()][p.getMatrixY()] instanceof KingWhite) {
                            pieces[MatrixX + x][MatrixY + y] = old_piece_on_board;
                            pieces[MatrixX][MatrixY] = piece;
                            return true;
                        }
                    }
                }
            }
        } else if(piece instanceof KingBlack) {
            for(Piece valute_piece : GameFrame.getGamePanel().getAllPiece()) {
                if(valute_piece instanceof PawnWhite) {
                    PawnWhite pawnWhite = (PawnWhite) valute_piece;
                    pawnWhite.setLegalMoss(pieces, true);
                    for(Position p : pawnWhite.getCaptureMoss()) {
                        if(pieces[p.getMatrixX()][p.getMatrixY()] instanceof KingBlack) {
                            pieces[MatrixX + x][MatrixY + y] = old_piece_on_board;
                            pieces[MatrixX][MatrixY] = piece;
                            return true;
                        }
                    }
                }
            }
        }

        for(Piece valute_piece : GameFrame.getGamePanel().getAllPiece()) {
            if(piece instanceof WhitePiece) {
                if(valute_piece instanceof WhitePiece) {
                    continue;
                }
                if(valute_piece == old_piece_on_board) {
                    continue;
                }
                valute_piece.setLegalMoss(pieces, true);
                for(Position p : valute_piece.getLegalMoss()) {
                    if(pieces[p.getMatrixX()][p.getMatrixY()] instanceof KingWhite) {
                        pieces[MatrixX + x][MatrixY + y] = old_piece_on_board;
                        pieces[MatrixX][MatrixY] = piece;
                        return true;
                    }
                }

            } else {
                if(valute_piece instanceof BlackPiece) {
                    continue;
                }
                if(valute_piece == old_piece_on_board) {
                    continue;
                }
                valute_piece.setLegalMoss(pieces, true);
                for(Position p : valute_piece.getLegalMoss()) {
                    if(pieces[p.getMatrixX()][p.getMatrixY()] instanceof KingBlack) {
                        pieces[MatrixX + x][MatrixY + y] = old_piece_on_board;
                        pieces[MatrixX][MatrixY] = piece;
                        return true;
                    }
                }

            }
        }
        pieces[MatrixX + x][MatrixY + y] = old_piece_on_board;
        pieces[MatrixX][MatrixY] = piece;
        return false;
    }

    public static void see_status_game() {
        if(check_win_white()) {
            gameStatus = GameStatus.VICTORY_WHITE;
            return;
        }

        if(check_win_black()) {
            gameStatus = GameStatus.VICTORY_BLACK;
            return;
        }

        if(check_draw_insufficient_material()) {
            gameStatus = GameStatus.DRAW_FOR_INSUFFICIENT_MATERIAL;
            return;
        }

        if(check_draw_stall()) {
            gameStatus = GameStatus.DRAW_FOR_STALL;
            return;
        }
    }

    private static boolean check_win_white() {
        for(Piece piece : GameFrame.getGamePanel().getAllPiece()) {
            GameFrame.getGamePanel().createLegalMoss(piece);
            if(piece instanceof BlackPiece) {
                if(piece.getLegalMoss().size() != 0) {
                    return false;
                }
            }
        }

        for(Piece piece : GameFrame.getGamePanel().getAllPiece()) {
            if(piece instanceof WhitePiece) {
                for(Position position : piece.getLegalMoss()) {
                    if(position == GameFrame.getGamePanel().getKingBlack().getPosition()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean check_win_black() {
        for(Piece piece : GameFrame.getGamePanel().getAllPiece()) {
            GameFrame.getGamePanel().createLegalMoss(piece);
            if(piece instanceof WhitePiece) {
                if(piece.getLegalMoss().size() != 0) {
                    return false;
                }
            }
        }

        for(Piece piece : GameFrame.getGamePanel().getAllPiece()) {
            if(piece instanceof BlackPiece) {
                for(Position position : piece.getLegalMoss()) {
                    if(position == GameFrame.getGamePanel().getKingWhite().getPosition()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean check_draw_insufficient_material() {

        return false;
    }

    private static boolean check_draw_stall() {
        return false;
    }
}


