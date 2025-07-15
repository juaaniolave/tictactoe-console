package Players.MovementStrategy;

import Game.Board;

import java.util.Random;

public class DefaultMovementStrategy {

    protected String getRandomCoordinates(Board board){
        Random random = new Random();
        int row = random.nextInt(3) + 1;  // genera 1 o 2
        int col = random.nextInt(3) + 1;
        if (!board.isCellFree(row,col)){
            return getRandomCoordinates(board);
        }
        return row + " " + col;
    }
}
