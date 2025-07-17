import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    @Test
    public void testValidStartUserEasy() {
        Menu menu = new Menu();
        String[] parts = {"start", "user", "easy"};
        assertTrue(menu.isValidCommand(parts), "Expected valid command: start user easy");
    }

    @Test
    public void testValidStartMediumHard() {
        Menu menu = new Menu();
        String[] parts = {"start", "medium", "hard"};
        assertTrue(menu.isValidCommand(parts), "Expected valid command: start medium hard");
    }

    @Test
    public void testInvalidCommandLength() {
        Menu menu = new Menu();
        String[] parts = {"start", "user"};
        assertFalse(menu.isValidCommand(parts), "Expected false for too few arguments");
    }

    @Test
    public void testInvalidStartKeyword() {
        Menu menu = new Menu();
        String[] parts = {"begin", "user", "easy"};
        assertFalse(menu.isValidCommand(parts), "Expected false for unknown command");
    }

    @Test
    public void testInvalidPlayerType() {
        Menu menu = new Menu();
        String[] parts = {"start", "banana", "easy"};
        assertFalse(menu.isValidCommand(parts), "Expected false for invalid player type");
    }
}
