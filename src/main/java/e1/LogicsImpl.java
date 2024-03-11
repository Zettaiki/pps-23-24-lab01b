package e1;

import e1.board.Board;
import e1.board.BoardImpl;
import e1.piece.PieceId;

public class LogicsImpl implements Logics {
	
	private final int boardSize;
	private final Board board;
	 
    public LogicsImpl(int boardSize){
    	this.boardSize = boardSize;
		this.board = new BoardImpl(this.boardSize);
		this.board.addPiece(PieceId.PAWN);
		this.board.addPiece(PieceId.KNIGHT);
    }

	public LogicsImpl(int boardSize, Pair<Integer, Integer> pawnPos, Pair<Integer, Integer> knightPos) {
		this.boardSize = boardSize;
		this.board = new BoardImpl(this.boardSize);
		this.board.addPiece(PieceId.PAWN, pawnPos);
		this.board.addPiece(PieceId.KNIGHT, knightPos);
	}

	@Override
	public boolean hit(int row, int col) {
		this.board.movePiece(PieceId.KNIGHT, new Pair<>(row, col));
        return this.board.getPiecePos(PieceId.KNIGHT).equals(this.board.getPiecePos(PieceId.PAWN));
    }

	@Override
	public boolean hasKnight(int row, int col) {
		return this.board.getPiecePos(PieceId.KNIGHT).equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.board.getPiecePos(PieceId.PAWN).equals(new Pair<>(row,col));
	}
}
