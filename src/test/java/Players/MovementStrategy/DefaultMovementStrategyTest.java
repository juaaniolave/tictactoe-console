package Players.MovementStrategy;

import Game.Board;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultMovementStrategyTest {

    @RepeatedTest(100)
    public void testGetRandomCoordinatesReturnsValidFreeCell() {
        Board board = new Board();
        DefaultMovementStrategy strategy = new DefaultMovementStrategy();

        String move = strategy.getRandomCoordinates(board);

        assertNotNull(move);
        assertTrue(move.matches("[1-3] [1-3]"), "Formato inválido: " + move);

        String[] parts = move.split(" ");
        int row = Integer.parseInt(parts[0]);
        int col = Integer.parseInt(parts[1]);

        assertTrue(board.isCellFree(row, col));
    }
}
