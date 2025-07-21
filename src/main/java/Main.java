import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run(new Scanner(System.in));
    }

    public static void run(Scanner scanner) {
        new Menu(scanner).showMenu();
    }
}
