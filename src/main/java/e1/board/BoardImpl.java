package e1.board;

import e1.Pair;
import e1.piece.Piece;
import e1.piece.PieceFactory;
import e1.piece.PieceId;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BoardImpl implements Board {

    List<Piece> pieceList;
    final int boardSize;

    public BoardImpl(final int boardSize) {
        this.pieceList = new ArrayList<>();
        this.boardSize = boardSize;
    }

    @Override
    public void addPiece(final PieceId pieceId) {
        try {
            getPiece(pieceId);
            throw new IllegalArgumentException("The piece already exists.");
        } catch(NoSuchElementException e) {
            pieceList.add(PieceFactory.generatePiece(pieceId, this.boardSize));
        }
    }

    @Override
    public void addPiece(final PieceId pieceId, final Pair<Integer, Integer> pos) {
        try {
            Board.checkIfOutOfBounds(this.boardSize, pos);
            getPiece(pieceId);
            throw new IllegalArgumentException("The piece already exists.");
        } catch(NoSuchElementException e) {
            pieceList.add(PieceFactory.generatePiece(pieceId, this.boardSize, pos));
        }
    }

    @Override
    public void movePiece(final PieceId pieceId, final Pair<Integer, Integer> newPos) {
        Piece piece = getPiece(pieceId);
        piece.move(newPos);
    }

    @Override
    public Pair<Integer, Integer> getPiecePos(final PieceId pieceId) {
        Piece piece = getPiece(pieceId);
        return piece.getPos();
    }

    private Piece getPiece(final PieceId pieceId) throws NoSuchElementException {
        for(Piece piece : pieceList) {
            if(piece.getId() == pieceId) {
                return piece;
            }
        }
        throw new NoSuchElementException("No such piece in the board.");
    }
}
