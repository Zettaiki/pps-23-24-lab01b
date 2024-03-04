package e1;

public interface ChessPiece {

    boolean move(Pair<Integer, Integer> cord);

    Pair<Integer, Integer> currentPos();

}
