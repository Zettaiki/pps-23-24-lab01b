package e1.piece.movement;

import e1.piece.PieceId;

import java.util.NoSuchElementException;

public class MovementFactory {

    private MovementFactory() {}

    public static Movement generateMovement(final PieceId pieceId, final int boardSize) {
        return switch (pieceId) {
            case KNIGHT -> generateKnightMovement(boardSize);
            case PAWN -> generatePawnMovement(boardSize);
            default -> throw new NoSuchElementException("The requested piece ID is not implemented in the factory.");
        };
    }

    private static Movement generateKnightMovement(final int boardSize) {
        return new KnightMovement(boardSize);
    }

    private static Movement generatePawnMovement(final int boardSize) {
        return new PawnMovement(boardSize);
    }

}
