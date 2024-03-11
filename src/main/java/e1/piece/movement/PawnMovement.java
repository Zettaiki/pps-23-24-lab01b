package e1.piece.movement;

import e1.Pair;
import e1.board.Board;

public class PawnMovement implements Movement {

    final private int boardSize;

    public PawnMovement(final int boardSize) {
        this.boardSize = boardSize;
    }

    @Override
    public boolean canMove(final Pair<Integer, Integer> currentPos, final Pair<Integer, Integer> nextPos) {
        Board.checkIfOutOfBounds(this.boardSize, nextPos);
        return false;
    }
}
