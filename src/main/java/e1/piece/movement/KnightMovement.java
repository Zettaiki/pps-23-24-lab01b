package e1.piece.movement;

import e1.Pair;
import e1.board.Board;
import e1.piece.PieceId;

public class KnightMovement implements Movement {

    final private int boardSize;

    public KnightMovement(final int boardSize) {
        this.boardSize = boardSize;
    }

    @Override
    public boolean canMove(final Pair<Integer, Integer> currentPos, final Pair<Integer, Integer> nextPos) {
        Board.checkIfOutOfBounds(this.boardSize, nextPos);

        int x = nextPos.getX() - currentPos.getX();
        int y = nextPos.getY() - currentPos.getY();

        return (x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == PieceId.KNIGHT.getSteps());
    }

}
