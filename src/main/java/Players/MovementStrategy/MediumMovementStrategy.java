package Players.MovementStrategy;

import Game.Board;

public class MediumMovementStrategy extends DefaultMovementStrategy implements IMovementStrategy {

public MediumMovementStrategy(){

}
    @Override
    public String makeMove(Board board, char userName) {
        System.out.println("Making move level \"Medium\"");
        String move = getCoordinatesForWinningMove(board, userName);
        if (move != null)
            return move;
        move = getCoordinatesForWinningMove(board, userName == 'X' ? 'O' : 'X');
        if (move != null)
            return move;
        return getRandomCoordinates(board);
    }

    private String getCoordinatesForWinningMove(Board board, char userName) {
        // Verificar filas
        for (int row = 0; row < 3; row++) {
            int count = 0;
            int emptyCol = -1;
            for (int col = 0; col < 3; col++) {
                char cell = board.getCell(row, col);
                if (cell == userName) count++;
                else if (cell == ' ') emptyCol = col;
            }
            if (count == 2 && emptyCol != -1) {
                return (row + 1) + " " + (emptyCol + 1);
            }
        }

        // Verificar columnas
        for (int col = 0; col < 3; col++) {
            int count = 0;
            int emptyRow = -1;
            for (int row = 0; row < 3; row++) {
                char cell = board.getCell(row, col);
                if (cell == userName)
                    count++;
                else if (cell == ' ')
                    emptyRow = row;
            }
            if (count == 2 && emptyRow != -1) {
                return (emptyRow + 1) + " " + (col + 1);
            }
        }

        // Verificar diagonal principal
        int countDiag = 0;
        int emptyDiag = -1;
        for (int i = 0; i < 3; i++) {
            char cell = board.getCell(i, i);
            if (cell == userName)
                countDiag++;
            else if (cell == ' ')
                emptyDiag = i;
        }
        if (countDiag == 2 && emptyDiag != -1) {
            return (emptyDiag + 1) + " " + (emptyDiag + 1);
        }

        // Verificar diagonal secundaria
        countDiag = 0;
        emptyDiag = -1;
        for (int i = 0; i < 3; i++) {
            char cell = board.getCell(i, 2 - i);
            if (cell == userName)
                countDiag++;
            else if (cell == ' ')
                emptyDiag = i;
        }
        if (countDiag == 2 && emptyDiag != -1) {
            return (emptyDiag + 1) + " " + (3 - emptyDiag);
        }

        // Si no hay jugada ganadora
        return null;
    }


}


