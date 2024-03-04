package e1;

import java.util.Random;

public class KnightPiece implements ChessPiece {

    private Pair<Integer, Integer> position;
    private final int size;

    public KnightPiece(int size) {
        this.size = size;
        Random random = new Random();
        this.position = new Pair<>(random.nextInt(size), random.nextInt(size));
    }

    public KnightPiece(int size, Pair<Integer, Integer> position) {
        this.size = size;
        this.position = position;
    }

    @Override
    public boolean move(Pair<Integer, Integer> cord) {
        if (cord.getX()<0 || cord.getY()<0 || cord.getX() >= this.size || cord.getY() >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        int x = cord.getX() - this.position.getX();
        int y = cord.getY() - this.position.getY();
        if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
            this.position = cord;
            return true;
        }
        return false;
    }

    @Override
    public Pair<Integer, Integer> currentPos() {
        return position;
    }
}
