package Players.MovementStrategy;

import Game.Board;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class EasyMovementStrategyTest {

    @Test
    public void testMakeMoveReturnsValidFreeCellAndPrintsMessage() {
        // Capturar System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Board board = new Board();
        EasyMovementStrategy strategy = new EasyMovementStrategy();
        String move = strategy.makeMove(board, 'X');

        // Restaurar salida estándar
        System.setOut(originalOut);

        // Verifica que la salida contenga el mensaje esperado
        assertTrue(outContent.toString().contains("Making move level \"easy\""));

        // Verifica que el string sea del tipo "1 2"
        assertNotNull(move);
        assertTrue(move.matches("[1-3] [1-3]"), "Formato inválido: " + move);

        // Verifica que la celda esté libre
        String[] parts = move.split(" ");
        int row = Integer.parseInt(parts[0]);
        int col = Integer.parseInt(parts[1]);
        assertTrue(board.isCellFree(row, col), "La celda no está libre");
    }
}
