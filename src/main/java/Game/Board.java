package Game;

public class Board {
    private char[][] board;

    public Board() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }


    public void setCell(int row, int col, char symbol) throws IllegalStateException{
        this.validateMove(row, col, symbol);
        board[row][col] = symbol;
    }
    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) System.out.print("| ");
                System.out.print(board[i][j] + " ");
                if (j == 2) System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("---------");
    }

    private void validateMove(int row, int col, char symbol) {
        if (board[row][col] != ' ' && symbol != ' ')
            throw new IllegalStateException("This cell is occupied! Choose another one!");
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner() {
        // Filas
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                    board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2]) {
                return true;
            }
        }

        // Columnas
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' &&
                    board[0][j] == board[1][j] &&
                    board[1][j] == board[2][j]) {
                return true;
            }
        }

        // Diagonal principal
        if (board[0][0] != ' ' &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {
            return true;
        }

        // Diagonal secundaria
        if (board[0][2] != ' ' &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }
    public boolean isCellFree(int row, int col){
        return board[row-1][col-1] == ' ';
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public Character getWinner() {
        // Filas
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' &&
                    board[i][0] == board[i][1] &&
                    board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }

        // Columnas
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' &&
                    board[0][j] == board[1][j] &&
                    board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }
        // Diagonal principal
        if (board[0][0] != ' ' &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {
            return board[0][0];
        }

        // Diagonal secundaria
        if (board[0][2] != ' ' &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {
            return board[0][2];
        }
        return null;
    }

}