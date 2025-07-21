package Players.MovementStrategy;

import Game.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MediumMovementStrategyTest {

    @Test
    public void testGanaSiPuede() {
        Board board = new Board();
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'X');
        // (0,2) libre → debería ganar

        MediumMovementStrategy strategy = new MediumMovementStrategy();
        String move = strategy.makeMove(board, 'X');

        assertEquals("1 3", move); // gana completando la fila 0
    }

    @Test
    public void testBloqueaAlOponente() {
        Board board = new Board();
        board.setCell(1, 0, 'O');
        board.setCell(1, 2, 'O');
        // (1,1) libre → debe bloquear

        MediumMovementStrategy strategy = new MediumMovementStrategy();
        String move = strategy.makeMove(board, 'X');

        assertEquals("2 2", move); // bloquea fila 1
    }

    @Test
    public void testHaceMovimientoAleatorio() {
        Board board = new Board();
        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'O');
        board.setCell(0, 2, 'X');
        board.setCell(1, 0, 'O');
        board.setCell(1, 1, 'X');
        board.setCell(1, 2, 'O');
        board.setCell(2, 0, 'X');
        board.setCell(2, 2, 'O');
        // Solo queda (2,1)

        MediumMovementStrategy strategy = new MediumMovementStrategy();
        String move = strategy.makeMove(board, 'X');

        assertEquals("3 2", move); // única opción válida
    }
}
