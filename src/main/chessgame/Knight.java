package main.chessgame;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(int startingColumn, int startingRow) {
        super(startingColumn, startingRow);
    }

    @Override
    public List<String> determinesMoves() {
        int[] columnMovements = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] rowMovements = {1, 2, 2, 1, -1, -2, -2, -1};
        ArrayList<String> knightMoves = new ArrayList<>();

        for (int i = 0; i < columnMovements.length; i++) {
            knightMoves.addAll(calculateMoves(columnMovements[i], rowMovements[i], this.startingColumn, this.startingRow));
        }
        return knightMoves;
    }

    private ArrayList<String> calculateMoves(int columnChange, int rowChange, int column, int row) {
        ArrayList<String> moves = new ArrayList<>();
        int newRow = row + rowChange;
        int newColumn = column + columnChange;
        if (newRow < 1 || newRow > 8 || newColumn < 1 || newColumn > 8) {

        } else {
            moves.add(Piece.Column.nameOf(newColumn) + newRow);
        }
        return moves;
    }

}
