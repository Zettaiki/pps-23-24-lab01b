package e1.board;

import e1.Pair;
import e1.piece.PieceId;

public interface Board {

    static void checkIfOutOfBounds(final int boardSize, final Pair<Integer, Integer> pos) throws IllegalArgumentException {
        if (pos.getX()<0 || pos.getY()<0 || pos.getX() >= boardSize || pos.getY() >= boardSize) {
            throw new IllegalArgumentException();
        }
    }
    void addPiece(PieceId pieceId);

    void addPiece(PieceId pieceId, Pair<Integer, Integer> pos);

    void movePiece(PieceId pieceId, Pair<Integer, Integer> newPos);

    Pair<Integer, Integer> getPiecePos(PieceId pieceId);

}
