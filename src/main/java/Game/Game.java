package Game;

import Players.Player;

public class Game {

    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player actualPlayer;

    public Game(Player playerX, Player playerO, Board board) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.board = board;
        this.actualPlayer=playerX;
    }


    public void start(){
        String nextMove;
        board.printBoard();
        while (!board.isFull() && !board.hasWinner()){
            try {
                nextMove = actualPlayer.makeMove(board);
                validateInputAndSetCell(nextMove);
                board.printBoard();
                if (actualPlayer==playerX){
                    actualPlayer=playerO;
                }
                else actualPlayer=playerX;
            }catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        if (board.isFull() && !board.hasWinner()){
            System.out.println("Draw");
        }
        else {
            if (actualPlayer == playerO)
                System.out.println(playerX.getUserName() + " wins");
            else
                System.out.println(playerO.getUserName() + " wins");
        }
    }
    protected void validateInputAndSetCell(String nextMove) throws IllegalArgumentException {
        String[] parts = nextMove.trim().split(" ");

        if (parts.length != 2) {
            throw new IllegalArgumentException("You should enter 2 numbers!");
        }

        int row, col;

        try {
            row = Integer.parseInt(parts[0]);
            col = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("You should enter numbers!");
        }

        if (row < 1 || row > 3 || col < 1 || col > 3) {
            throw new IllegalArgumentException("Coordinates should be from 1 to 3!");
        }

        // restamos 1 porque el usuario ingresa del 1 al 3, pero el array es 0 a 2
        board.setCell(row - 1, col - 1, actualPlayer.getUserName());
    }
    public Board getBoard() {
        return board;
    }


}
