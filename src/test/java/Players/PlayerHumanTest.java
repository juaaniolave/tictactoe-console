package Players;

import Game.Board;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerHumanTest {
    @Test
    public void testPlayerHumanReadsInputCorrectly() {
        // Simular input: usuario escribe "1 1"
        String simulatedInput = "1 1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Capturar el output (por ejemplo, para verificar el mensaje "Enter the coordinates")
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Ejecutar
        PlayerHuman player = new PlayerHuman('X');
        String move = player.makeMove(new Board());

        // Restaurar streams
        System.setIn(System.in);
        System.setOut(originalOut);

        // Verificar
        assertEquals("1 1", move); //
        assertTrue(outContent.toString().contains("Enter the coordinates")); //
    }

}
