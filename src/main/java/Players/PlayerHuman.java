package Players;

import Game.Board;

public class PlayerHuman extends Player{
    public PlayerHuman(char userName) {
        super(userName);
    }

    @Override
    public String makeMove(Board board) {
        System.out.print("Enter the coordinates: ");
        return scanner.nextLine();
    }
}
