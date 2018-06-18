package test.chessgame;

import main.chessgame.ChessGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ChessGameTest {

    @Test
    public void testChessGame_Queen() {
        String valid = "a5, b5, c5, d5, f5, g5, h5, e1, e2, e3, e4, e6, e7, e8, f6, g7, h8, f4, g3, h2, d6, c7, b8, d4, c3, b2, a1";
        assertEquals(valid, new ChessGame("queen", "e5").runGame());
    }

    @Test
    public void testChessGame_Rook() {
        String valid = "a5, b5, c5, d5, f5, g5, h5, e1, e2, e3, e4, e6, e7, e8";
        assertEquals(valid, new ChessGame("rook", "e5").runGame());
    }

    @Test
    public void testChessGame_Knight() {
        String valid = "f3, e4, c4, b3, b1, f1";
        assertEquals(valid, new ChessGame("knight", "d2").runGame());
    }

    @Test
    public void testChessGame_InvalidPiece() {
        assertNull(new ChessGame("test", "d2").runGame());
    }

    @Test
    public void testChessGame_InvalidPosition_Column() {
        assertNull(new ChessGame("test", "z2").runGame());
    }

    @Test
    public void testChessGame_InvalidPosition_Row() {
        assertNull(new ChessGame("test", "d9").runGame());
    }

    @Test
    public void testChessGame_Knight_UpperCase() {
        String valid = "f3, e4, c4, b3, b1, f1";
        assertEquals(valid, new ChessGame("knight", "D2").runGame());
    }

    @Test
    public void testChessGame_NullPiece() {
        assertNull(new ChessGame(null, "d8").runGame());
        assertNull(new ChessGame("", "d8").runGame());

    }

    @Test
    public void testChessGame_NullPosition() {
        assertNull(new ChessGame("queen", null).runGame());
        assertNull(new ChessGame("queen", "").runGame());

    }
}
