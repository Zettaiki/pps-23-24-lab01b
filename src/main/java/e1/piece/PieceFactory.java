package e1.piece;

import e1.Pair;

import java.util.NoSuchElementException;

public class PieceFactory {

    private PieceFactory() {}

    public static Piece generatePiece(final PieceId pieceId, final int boardSize) {
        return switch (pieceId) {
            case KNIGHT -> generateKnightPiece(boardSize);
            case PAWN -> generatePawnPiece(boardSize);
            default -> throw new NoSuchElementException();
        };
    }

    public static Piece generatePiece(final PieceId pieceId, final int boardSize, Pair<Integer, Integer> pos) {
        return switch (pieceId) {
            case KNIGHT -> generateKnightPiece(boardSize, pos);
            case PAWN -> generatePawnPiece(boardSize, pos);
            default -> throw new NoSuchElementException();
        };
    }

    private static Piece generateKnightPiece(final int boardSize) {
        return new PieceImpl(PieceId.KNIGHT, boardSize);
    }

    private static Piece generateKnightPiece(int boardSize, Pair<Integer, Integer> pos) {
        return new PieceImpl(PieceId.KNIGHT, boardSize, pos);
    }

    private static Piece generatePawnPiece(int boardSize) {
        return new PieceImpl(PieceId.PAWN, boardSize);
    }

    private static Piece generatePawnPiece(int boardSize, Pair<Integer, Integer> pos) {
        return new PieceImpl(PieceId.PAWN, boardSize, pos);
    }

}
