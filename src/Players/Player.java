package Players;

import java.util.Scanner;
import Game.Board;

public abstract class Player {

    protected char userName;
    protected double score;
    protected Scanner scanner;

    public Player (char userName){
        this.userName = userName;
        this.scanner = new Scanner(System.in);
    }

    public char getUserName(){
        return this.userName;
    }

    public abstract String makeMove(Board board);

}
