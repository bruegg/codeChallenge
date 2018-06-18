package main.chessgame;

import java.util.List;

public class ChessGame {
    private String chessPiece;
    private String startingPosition;

    public ChessGame(String chessPiece, String startingPosition) {
        this.chessPiece = chessPiece;
        this.startingPosition = startingPosition;
        runGame();
    }

    public String runGame() {
        Piece.ChessPiece piece = Piece.ChessPiece.fromValue(chessPiece);
        if (piece == null) {
            return null;
        }
        if (startingPosition != null && startingPosition.length() == 2) {
            String column = startingPosition.toLowerCase().split("")[0];
            int startingColumn = Piece.Column.valueOf(column).getValue();
            int startingRow = Integer.parseInt(startingPosition.split("")[1]);

            if ((startingColumn > 0 && startingColumn <= 8) && (startingRow > 0 && startingRow <= 8)) {
                switch (piece) {
                    case QUEEN:
                        return printValues(new Queen(startingColumn, startingRow).determinesMoves());
                    case ROOK:
                        return printValues(new Rook(startingColumn, startingRow).determinesMoves());
                    case KNIGHT:
                        return printValues(new Knight(startingColumn, startingRow).determinesMoves());
                    default:
                        return "";
                }
            } else {
                System.out.println("Error: Starting position must be on the board");
            }
        } else {
            System.out.println("Error: Invalid starting position");
        }
        return null;
    }

    private String printValues(List<String> moves) {
        String movesString = String.join(", ", moves);
        System.out.println(movesString);
        return movesString;
    }

    public static void main(String[] args) {
        new ChessGame(args[0], args[1]);
    }

}
