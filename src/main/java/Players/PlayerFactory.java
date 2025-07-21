package Players;

import Players.MovementStrategy.EasyMovementStrategy;
import Players.MovementStrategy.HardMovementStrategy;
import Players.MovementStrategy.MediumMovementStrategy;

public class PlayerFactory {
    public static Player createPlayer(PlayerType type, char userName) {

        if (type == null) {
            throw new IllegalArgumentException("Tipo de jugador no válido: null");
        }
        return switch (type) {
            case USER -> new PlayerHuman(userName);
            case EASY -> new PlayerIA(new EasyMovementStrategy(), userName);
            case MEDIUM -> new PlayerIA(new MediumMovementStrategy(), userName);
            case HARD -> new PlayerIA(new HardMovementStrategy(), userName);
            default -> throw new IllegalArgumentException("Tipo de jugador no válido: " + type);
        };
    }
}

