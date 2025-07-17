package Game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    public void testHorizontalWinRow0() {
        Board board = new Board();
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'X');
        board.setCell(0, 2, 'X');
        assertTrue(board.hasWinner(), "Expected winner on top row");
    }

    @Test
    public void testVerticalWinCol1() {
        Board board = new Board();
        board.setCell(0, 1, 'O');
        board.setCell(1, 1, 'O');
        board.setCell(2, 1, 'O');
        assertTrue(board.hasWinner(), "Expected winner on column 1");
    }

    @Test
    public void testDiagonalWinTopLeftToBottomRight() {
        Board board = new Board();
        board.setCell(0, 0, 'X');
        board.setCell(1, 1, 'X');
        board.setCell(2, 2, 'X');
        assertTrue(board.hasWinner(), "Expected winner on main diagonal");
    }

    @Test
    public void testDiagonalWinTopRightToBottomLeft() {
        Board board = new Board();
        board.setCell(0, 2, 'O');
        board.setCell(1, 1, 'O');
        board.setCell(2, 0, 'O');
        assertTrue(board.hasWinner(), "Expected winner on anti-diagonal");
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
}
