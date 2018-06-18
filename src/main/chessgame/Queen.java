package main.chessgame;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(int startingColumn, int startingRow) {
        super(startingColumn, startingRow);
    }

    @Override
    public List<String> determinesMoves() {
        List<String> moves = new Rook(startingColumn, startingRow).determinesMoves();
        moves.addAll(determineDiagonalMoves());
        return moves;
    }

    public List<String> determineDiagonalMoves() {
        int[] columnMovements = {1, 1, -1, -1};
        int[] rowMovements = {1, -1, 1, -1};
        ArrayList<String> diagonalMoves = new ArrayList<>();
        for (int i = 0; i < columnMovements.length; i++) {
            diagonalMoves.addAll(calculateMoves(columnMovements[i], rowMovements[i]));
        }
        return diagonalMoves;
    }

    private ArrayList<String> calculateMoves(int columnChange, int rowChange) {
        ArrayList<String> moves = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            int newRowPosition = startingRow + rowChange * i;
            int newColumnPosition = startingColumn + columnChange * i;
            if (newRowPosition < 1 || newRowPosition > 8 || newColumnPosition < 1 || newColumnPosition > 8) {
                break;
            } else {
                moves.add(Column.nameOf(newColumnPosition) + newRowPosition);
            }
        }
        return moves;
    }

}
