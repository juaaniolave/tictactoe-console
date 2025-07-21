package Players.MovementStrategy;

import Game.Board;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HardMovementStrategyTest {

    @Test
    public void testHardStrategyWinsIfPossible() {
        Board board = new Board();
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'X');
        board.setCell(1, 0, 'O');
        board.setCell(1, 1, 'O');
        // (0,2) es la victoria clara

        HardMovementStrategy strategy = new HardMovementStrategy();
        String move = strategy.makeMove(board, 'X');

        assertEquals("1 3", move); // gana completando fila 0
    }

    @Test
    public void testHardStrategyBlocksEnemyWin() {
        Board board = new Board();
        board.setCell(0, 0, 'O');
        board.setCell(0, 1, 'O');
        board.setCell(1, 1, 'X');
        // (0,2) es la jugada ganadora de 'O', que debe ser bloqueada

        HardMovementStrategy strategy = new HardMovementStrategy();
        String move = strategy.makeMove(board, 'X');

        assertEquals("1 3", move); // bloquea
    }
    @Test
    public void testHardStrategyMakesValidMoveWhenNeutral() {
        Board board = new Board(); // todo vacío

        HardMovementStrategy strategy = new HardMovementStrategy();
        String move = strategy.makeMove(board, 'X');

        assertNotNull(move);
        assertTrue(move.matches("[1-3] [1-3]"));
    }

    @RepeatedTest(20)
    public void testHardStrategyNeverCrashesRandom() {
        Board board = new Board();
        board.setCell(0, 0, 'X');
        board.setCell(0, 2, 'O');

        HardMovementStrategy strategy = new HardMovementStrategy();
        String move = strategy.makeMove(board, 'X');

        assertNotNull(move);
        assertTrue(move.matches("[1-3] [1-3]"));
    }

}
