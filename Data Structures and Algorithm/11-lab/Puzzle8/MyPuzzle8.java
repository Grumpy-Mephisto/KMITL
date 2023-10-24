import java.util.Arrays;

public class MyPuzzle8 {
    final static int[] data = {9, 1, 3, 4, 2, 5, 7, 8, 6};

    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
    }

    public static void demo1() {
        System.out.println("‹‹‹‹‹‹ Demo 1 ››››››");
        Puzzle8_65050437 game = new Puzzle8_65050437(data);
        game.displayBoard();
    }

    public static void demo2() {
        System.out.println("‹‹‹‹‹‹ Demo 2 ››››››");
        Puzzle8_65050437 game = new Puzzle8_65050437(data);
        game.generateNextMove();
    }

    public static void demo3() {
        System.out.println("‹‹‹‹‹‹ Demo 3 ››››››");
        Puzzle8_65050437 game = new Puzzle8_65050437(data);
        game.generateNextMoveWithStack();
        System.out.println(game.explored.size());
        System.out.println("Partial explored states:");
        for (Puzzle8State state : game.explored) {
            if (state.sequence[0] == 1 && state.sequence[1] == 2 && state.sequence[2] == 3
                    && state.sequence[3] == 4) {
                System.out.println(Arrays.toString(state.sequence));
            }
            System.out.println(
                    "Note that the program terminates prior to pushing goal state into explored!!");
        }
    }
}
