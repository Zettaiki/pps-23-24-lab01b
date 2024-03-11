package e1.piece;

public enum PieceId {
    PAWN(0),
    KNIGHT(3);

    private final int steps;

    PieceId(int steps) {
        this.steps = steps;
    }

    public int getSteps() {
        return this.steps;
    }
}
