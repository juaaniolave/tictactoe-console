package Game;

import Players.MovementStrategy.EasyMovementStrategy;
import Players.Player;
import Players.PlayerFactory;
import Players.PlayerType;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    private Player createIA(char symbol) {
        return PlayerFactory.createPlayer(PlayerType.EASY, symbol);
    }

    @Test
    public void testGameWithWinner() {
        Player playerX = createIA('X');
        Player playerO = createIA('O');

        Game game = new Game(playerX, playerO, new Board());
        game.getBoard().setCell(0, 0, 'X');
        game.getBoard().setCell(0, 1, 'X');
        game.getBoard().setCell(0, 2, 'X');

        assertTrue(game.getBoard().hasWinner());
    }

    @Test
    public void testDrawGame() {
        Player playerX = createIA('X');
        Player playerO = createIA('O');

        Game game = new Game(playerX, playerO, new Board());
        Board board = game.getBoard();

        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'O');
        board.setCell(0, 2, 'X');
        board.setCell(1, 0, 'O');
        board.setCell(1, 1, 'X');
        board.setCell(1, 2, 'O');
        board.setCell(2, 0, 'O');
        board.setCell(2, 1, 'X');
        board.setCell(2, 2, 'O');

        assertTrue(board.isFull());
        assertFalse(board.hasWinner());
    }

    @Test
    public void testStartPrintsBoardAndAnnouncesWinner() {
        Player playerX = createIA('X');
        Player playerO = createIA('O');

        Game game = new Game(playerX, playerO, new Board());
        game.getBoard().setCell(0, 0, 'X');
        game.getBoard().setCell(0, 1, 'X');
        game.getBoard().setCell(0, 2, 'X');

        game.start(); // como es IA, no requiere input real

        String output = outContent.toString();
        assertFalse(output.contains("Player X wins!") || output.contains("Player O wins!") || output.contains("Draw"));
    }

    @Test
    public void testValidInputSetsCell() {
        Player playerX = createIA('X');
        Player playerO = createIA('O');
        Game game = new Game(playerX, playerO, new Board());

        game.validateInputAndSetCell("1 2");

        assertEquals('X', game.getBoard().getCell(0, 1));
    }

    @Test
    public void testStartGameWithWinner() {
        Player playerX = PlayerFactory.createPlayer(PlayerType.EASY, 'X');
        Player playerO = PlayerFactory.createPlayer(PlayerType.EASY, 'O');
        Game game = new Game(playerX, playerO, new Board());

        // Fuerzo una victoria de X antes de empezar
        game.getBoard().setCell(0, 0, 'X');
        game.getBoard().setCell(0, 1, 'X');
        game.getBoard().setCell(0, 2, 'X');

        game.start();

        String output = outContent.toString();
        assertTrue(output.contains("wins"));
    }

    @Test
    public void testStartGameWithDraw() {
        Player playerX = PlayerFactory.createPlayer(PlayerType.EASY, 'X');
        Player playerO = PlayerFactory.createPlayer(PlayerType.EASY, 'O');
        Game game = new Game(playerX, playerO, new Board());

        Board board = game.getBoard();

        board.setCell(0, 0, 'X');
        board.setCell(0, 1, 'O');
        board.setCell(0, 2, 'X');
        board.setCell(1, 0, 'X');
        board.setCell(1, 1, 'O');
        board.setCell(1, 2, 'O');
        board.setCell(2, 0, 'O');
        board.setCell(2, 1, 'X');
        board.setCell(2, 2, 'X');

        game.start();

        String output = outContent.toString();
        assertTrue(output.contains("Draw"));
    }

    @Test
    public void simulateHardGame() {
        Player playerX = PlayerFactory.createPlayer(PlayerType.HARD, 'X');
        Player playerO = PlayerFactory.createPlayer(PlayerType.HARD, 'O');
        Game game = new Game(playerX, playerO, new Board());
        game.start();
        String output = outContent.toString();
        assertTrue(output.contains("Draw"));
    }

}
