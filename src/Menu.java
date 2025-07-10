import Game.Board;
import Game.Game;
import Players.Player;
import Players.PlayerFactory;
import Players.PlayerType;

import java.util.Scanner;

public class Menu {

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input command: ");
        String command = scanner.nextLine();

        while (!command.equals("exit")) {
            String[] parts = command.trim().split("\\s+");

            if (isValidCommand(parts)) {
                executeCommand(parts);
            } else {
                System.out.println("Bad parameters!");
            }

            System.out.print("Input command: ");
            command = scanner.nextLine();
        }
    }

    private boolean isValidCommand(String[] parts) {
        if (parts.length != 3 || !parts[0].equalsIgnoreCase("start")) {
            return false;
        }

        try {
            parsePlayerType(parts[1]);
            parsePlayerType(parts[2]);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private void executeCommand(String[] parts) {
        try {
            PlayerType typeX = parsePlayerType(parts[1]);
            PlayerType typeO = parsePlayerType(parts[2]);
            Player playerX = PlayerFactory.createPlayer(typeX, 'X');
            Player playerO = PlayerFactory.createPlayer(typeO, 'O');
            Board board = new Board();
            Game game = new Game(playerX, playerO, board);
            game.start();
        } catch (Exception e) {
            System.out.println("Error al iniciar el juego: " + e.getMessage());
        }
    }

    private PlayerType parsePlayerType(String input) throws IllegalArgumentException {
        return PlayerType.valueOf(input.toUpperCase());
    }
}
