package Game;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testHorizontalWinRow2() {
        Board board = new Board();
        board.setCell(2, 0, 'X');
        board.setCell(2, 1, 'X');
        board.setCell(2, 2, 'X');
        assertTrue(board.hasWinner(), "Expected winner on top row");
    }

    @Test
    public void testVerticalWinCol2() {
        Board board = new Board();
        board.setCell(0, 2, 'O');
        board.setCell(1, 2, 'O');
        board.setCell(2, 2, 'O');
        assertTrue(board.hasWinner(), "Expected winner on column 1");
    }

    @Test
    public void testDiagonalWinTopLeftToBottomRight() {
        Board board = new Board();
        board.setCell(0, 0, 'X');
        board.setCell(1, 1, 'X');
        board.setCell(2, 2, 'X');
        assertTrue(board.hasWinner(), "Expected winner on main diagonal");
        assertEquals('X', board.getWinner());

    }

    @Test
    public void testDiagonal2() {
        Board board = new Board();
        board.setCell(0, 2, 'X');
        board.setCell(1, 1, 'X');
        board.setCell(2, 0, 'X');
        assertTrue(board.hasWinner(), "Expected winner on main diagonal");
        assertEquals('X', board.getWinner());

    }

    @Test
    public void testDiagonalWinTopRightToBottomLeft() {
        Board board = new Board();
        board.setCell(0, 2, 'O');
        board.setCell(1, 1, 'O');
        board.setCell(2, 0, 'O');
        assertTrue(board.hasWinner(), "Expected winner on anti-diagonal");
        assertEquals('O', board.getWinner());
    }

    @Test
    public void testNoWinner() {
        Board board = new Board();
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'O');
        board.setCell(0, 2, 'X');
        board.setCell(1, 0, 'X');
        board.setCell(1, 1, 'O');
        board.setCell(1, 2, 'O');
        board.setCell(2, 0, 'O');
        board.setCell(2, 1, 'X');
        board.setCell(2, 2, 'X');
        assertFalse(board.hasWinner(), "Expected no winner in full board with no line");
        assertNull(board.getWinner());
    }

    @Test
    public void testIsFullReturnsFalseWhenEmpty() {
        Board board = new Board();
        assertFalse(board.isFull(), "Expected board not to be full initially");
    }

    @Test
    public void testIsFullReturnsTrueWhenFull() {
        Board board = new Board();
        board.setCell(0, 0, 'X');
        assertFalse(board.isFull(), "Expected board to not be full");
        board.setCell(0, 1, 'O');
        assertFalse(board.isFull(), "Expected board to not be full");
        board.setCell(0, 2, 'X');
        assertFalse(board.isFull(), "Expected board to not be full");
        board.setCell(1, 0, 'X');
        assertFalse(board.isFull(), "Expected board to not be full");
        board.setCell(1, 1, 'O');
        assertFalse(board.isFull(), "Expected board to not be full");
        board.setCell(1, 2, 'O');
        assertFalse(board.isFull(), "Expected board to not be full");
        board.setCell(2, 0, 'O');
        assertFalse(board.isFull(), "Expected board to not be full");
        board.setCell(2, 1, 'X');
        assertFalse(board.isFull(), "Expected board to not be full");
        board.setCell(2, 2, 'X');
        assertTrue(board.isFull(), "Expected board to be full");
    }

    @Test
    public void testPrintBoard() {
        Board board = new Board();
        board.setCell(0, 0, 'X');
        board.setCell(1, 1, 'O');
        board.setCell(2, 2, 'X');

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        board.printBoard();

        System.setOut(System.out);

        String expected =
                "---------\n" +
                        "| X \0 \0 |\n" +
                        "| \0 O \0 |\n" +
                        "| \0 \0 X |\n" +
                        "---------\n";

        String actual = outContent.toString().replace('\0', ' ').replace("\r\n", "\n");


        String expectedNormalized =
                "---------\n" +
                        "| X     |\n" +
                        "|   O   |\n" +
                        "|     X |\n" +
                        "---------\n";

        assertEquals(expectedNormalized, actual);
    }

}
