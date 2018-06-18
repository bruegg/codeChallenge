package main.chessgame.piece;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    int[] columns = {1, 2, 3, 4, 5, 6, 7, 8};
    int[] rows = {1, 2, 3, 4, 5, 6, 7, 8};

    protected int startingColumn;
    protected int startingRow;

    public Piece(int startingColumn, int startingRow) {
        this.startingColumn = startingColumn;
        this.startingRow = startingRow;
    }

    public abstract List<String> determinesMoves();

    protected ArrayList<String> determineHorizontal() {
        ArrayList<String> horizontalMoves = new ArrayList<String>();
        for (int i = 0; i < columns.length; i++) {
            if (!("" + columns[i] + startingRow).equals("" + startingColumn + startingRow)) {
                horizontalMoves.add(Column.nameOf(columns[i]) + startingRow);
            }
        }
        return horizontalMoves;
    }

    protected ArrayList<String> determineVertical() {
        ArrayList<String> verticalMoves = new ArrayList<String>();
        for (int i = 0; i < columns.length; i++) {
            if (!("" + startingColumn + rows[i]).equals("" + startingColumn + startingRow)) {
                verticalMoves.add(Column.nameOf(startingColumn) + rows[i]);
            }
        }
        return verticalMoves;
    }

    /**
     * Used to convert columns from numbers to letters or vice versa
     */
    public enum Column {
        a(1),
        b(2),
        c(3),
        d(4),
        e(5),
        f(6),
        g(7),
        h(8);

        private int value;

        Column(int number) {
            this.value = number;
        }

        public int getValue() {
            return value;
        }

        public static String nameOf(int num) {
            for (Column val : Column.values()) {
                if (val.value == num) {
                    return val.toString();
                }
            }
            return null;
        }
    }


    /**
     * Determine chess piece from entry
     */
    public enum ChessPiece {
        QUEEN("queen"),
        ROOK("rook"),
        KNIGHT("knight");

        private String value;

        ChessPiece(String piece) {
            this.value = piece;
        }

        public static ChessPiece fromValue(String val) {
            if (val != null) {
                for (ChessPiece chessPiece : ChessPiece.values()) {
                    if (chessPiece.value.equals(val.toLowerCase())) {
                        return chessPiece;
                    }
                }
            }
            System.out.println(String.format("Piece entered '%s' is not a valid piece", val));
            return null;
        }
    }
}
