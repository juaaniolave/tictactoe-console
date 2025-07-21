package Players;

import Players.*;
import Players.MovementStrategy.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerFactoryTest {

    @Test
    public void testCreatePlayerHuman() {
        Player player = PlayerFactory.createPlayer(PlayerType.USER, 'X');
        assertNotNull(player);
        assertTrue(player instanceof PlayerHuman);
        assertEquals('X', player.getUserName());
    }

    @Test
    public void testCreatePlayerEasy() {
        Player player = PlayerFactory.createPlayer(PlayerType.EASY, 'O');
        assertNotNull(player);
        assertTrue(player instanceof PlayerIA);
        assertEquals('O', player.getUserName());
    }

    @Test
    public void testCreatePlayerMedium() {
        Player player = PlayerFactory.createPlayer(PlayerType.MEDIUM, 'X');
        assertNotNull(player);
        assertTrue(player instanceof PlayerIA);
        assertEquals('X', player.getUserName());
    }

    @Test
    public void testCreatePlayerHard() {
        Player player = PlayerFactory.createPlayer(PlayerType.HARD, 'X');
        assertNotNull(player);
        assertTrue(player instanceof PlayerIA);
        assertEquals('X', player.getUserName());
    }

    @Test
    public void testCreatePlayerWithInvalidTypeThrows() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PlayerFactory.createPlayer(null, 'X');
        });

        assertEquals("Tipo de jugador no válido: null", exception.getMessage());
    }

}
