package e1.piece.movement;

import e1.Pair;

public interface Movement {

    boolean canMove(Pair<Integer, Integer> currentPos, Pair<Integer, Integer> nextPos);

}
