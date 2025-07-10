package Players;

import Game.Board;
import Players.MovementStrategy.IMovementStrategy;

public class PlayerIA extends Player{

    IMovementStrategy movementStrategy;

    public PlayerIA(IMovementStrategy movementStrategy, char userName) {
        super(userName);
        this.movementStrategy = movementStrategy;
    }

    @Override
    public String makeMove(Board board) {
        return movementStrategy.makeMove(board, this.userName);
    }
}
