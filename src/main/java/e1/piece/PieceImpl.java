package e1.piece;

import e1.Pair;
import e1.piece.movement.Movement;
import e1.piece.movement.MovementFactory;

import java.util.Random;

public class PieceImpl implements Piece {

    final private PieceId pieceId;
    final private Movement movement;
    private Pair<Integer, Integer> position;

    public PieceImpl(final PieceId pieceId, final int boardSize) {
        this.pieceId = pieceId;
        Random random = new Random();
        this.position = new Pair<>(random.nextInt(boardSize), random.nextInt(boardSize));
        this.movement = MovementFactory.generateMovement(this.pieceId, boardSize);
    }

    public PieceImpl(final PieceId pieceId, final int boardSize, final Pair<Integer, Integer> position) {
        this.pieceId = pieceId;
        this.position = position;
        this.movement = MovementFactory.generateMovement(this.pieceId, boardSize);
    }

    @Override
    public PieceId getId() {
        return this.pieceId;
    }

    @Override
    public boolean move(final Pair<Integer, Integer> nextPos) {
        if(this.movement.canMove(this.position, nextPos)) {
            position = nextPos;
            return true;
        }
        return false;
    }

    @Override
    public Pair<Integer, Integer> getPos() {
        return position;
    }
}
