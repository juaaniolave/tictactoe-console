package Players.MovementStrategy;

import Game.Board;

public class EasyMovementStrategy extends DefaultMovementStrategy implements IMovementStrategy {

public EasyMovementStrategy(){

}
    @Override
    public String makeMove(Board board, char userName) {
        System.out.println("Making move level \"easy\"");
        return getRandomCoordinates(board);
    }

}


