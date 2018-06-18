package main.chessgame;

import java.util.List;

public class Rook extends Piece {

    public Rook(int startingColumn, int startingRow) {
        super(startingColumn, startingRow);
    }

    @Override
    public List<String> determinesMoves() {
        List<String> moves = determineHorizontal();
        moves.addAll(determineVertical());
        return moves;
    }
}
