package e1.piece;

import e1.Pair;

public interface Piece {

    PieceId getId();

    boolean move(Pair<Integer, Integer> cord);

    Pair<Integer, Integer> getPos();

}
