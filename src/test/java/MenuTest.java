import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.Scanner;


public class MenuTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testComandoInvalido() {
        String input = "foo bar\nexit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Menu menu = new Menu(scanner);

        menu.showMenu();

        String output = outContent.toString();
        assertTrue(output.contains("Bad parameters!"));
    }

    @Test
    public void testComandoValidoLlamaJuego() {
        String input = "start easy easy\nexit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Menu menu = new Menu(scanner);
        menu.showMenu();
        String output = outContent.toString();
        assertTrue(output.contains("X") || output.contains("O") || output.contains("---------")); // algo del tablero
    }

    @Test
    public void testSalirConExit() {
        String input = "exit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Menu menu = new Menu(scanner);

        menu.showMenu();

        String output = outContent.toString();
        assertTrue(output.contains("Input command:"));
    }

    @Test
    public void testComandoConMenosDeTresPartes() {
        String input = "start user\nexit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Menu menu = new Menu(scanner);

        menu.showMenu();

        String output = outContent.toString();
        assertTrue(output.contains("Bad parameters!"));
    }

    @Test
    public void testComandoConPlayerTypeInvalido() {
        String input = "start robot easy\nexit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Menu menu = new Menu(scanner);

        menu.showMenu();

        String output = outContent.toString();
        assertTrue(output.contains("Bad parameters!"));
    }


}
