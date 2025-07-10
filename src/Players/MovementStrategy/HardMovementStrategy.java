package Players.MovementStrategy;

import Game.Board;

public class HardMovementStrategy extends DefaultMovementStrategy implements IMovementStrategy {

public HardMovementStrategy(){

}
    @Override
    public String makeMove(Board board, char userName) {
            return getBestMove(board, userName, userName == 'X' ? 'O' : 'X');
    }

    public String getBestMove(Board board, char userName, char enemyUserName) {
        int bestScore = Integer.MIN_VALUE;
        String bestMove = null;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getCell(row, col) == ' ') {
                    board.setCell(row, col, userName);
                    int score = minimax(board, false, userName, enemyUserName);
                    board.setCell(row, col, ' '); // deshacer
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = (row + 1) + " " + (col + 1);
                    }
                }
            }
        }

        return bestMove;
    }

    private int minimax(Board board, boolean isMaximizing, char userName, char enemyUserName) {
        Character winner = board.getWinner(); // asumimos que devuelve 'X', 'O' o null
        if (winner != null) {
            if (winner == userName) return 10;
            else if (winner == enemyUserName) return -10;
        } else if (board.isFull()) {
            return 0;
        }

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getCell(row, col) == ' ') {
                    board.setCell(row, col, isMaximizing ? userName : enemyUserName);
                    int score = minimax(board, !isMaximizing, userName, enemyUserName);
                    board.setCell(row, col, ' '); // deshacer

                    if (isMaximizing) {
                        bestScore = Math.max(score, bestScore);
                    } else {
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
        }

        return bestScore;
    }

}


