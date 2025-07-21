import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testMainRunWithOnlyExit() {
        // Simula que el usuario escribe solo "exit"
        String simulatedInput = "exit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Capturar salida
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Ejecutar sin lanzar excepción
        assertDoesNotThrow(() -> Main.run(scanner));

        System.setOut(originalOut);

        // Verifica que no se imprimió algo vacío
        assertFalse(outContent.toString().isEmpty(), "No se imprimió nada");
    }
}
