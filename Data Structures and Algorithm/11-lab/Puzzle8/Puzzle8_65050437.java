import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Puzzle8_65050437 {

    static final int size = 3;
    int[] sequence;
    ArrayList<Puzzle8State> explored = new ArrayList<>();
    Stack<Puzzle8State> dfs = new Stack<>();

    public Puzzle8_65050437(int[] data) {
        int[] s = new int[9];
        for (int i = 0; i < data.length; i++) {
            if (i % 3 == 0) {
                int pos = coordToInt(data[i + 1], data[i + 2]);
                s[pos] = data[i];
            }
        }
        sequence = s;
    }

    /**
     * Task 1
     * 
     * @description Display the board
     */
    public void displayBoard() {
        for (int i = 0; i < sequence.length; i++) {
            if (i % 3 == 0 && i != 0)
                System.out.println();
            if (sequence[i] == 9)
                System.out.print("  ");
            else
                System.out.print(sequence[i] + " ");
        }
        System.out.println();
    }

    /**
     * Task 2
     * 
     * @description Generate next move
     */
    public void generateNextMove() {
        Stack<Puzzle8State> arr = generateNextMove(sequence);
        for (Puzzle8State s : arr) {
            System.out.println(Arrays.toString(s.sequence));
        }
    }

    private Stack<Puzzle8State> generateNextMove(int[] seque) {
        int blankPos = getBlankPos(seque);
        Stack<Puzzle8State> pzstate = new Stack<>();
        if (blankPos - 3 > 0)
            pzstate.add(new Puzzle8State(swapInArray(seque.clone(), blankPos, blankPos - 3)));
        if (blankPos + 3 < seque.length)
            pzstate.add(new Puzzle8State(swapInArray(seque.clone(), blankPos, blankPos + 3)));
        if (blankPos % 3 > 0)
            pzstate.add(new Puzzle8State(swapInArray(seque.clone(), blankPos, blankPos - 1)));
        if (blankPos % 3 < 2)
            pzstate.add(new Puzzle8State(swapInArray(seque.clone(), blankPos, blankPos + 1)));
        return pzstate;
    }

    /**
     * Task 3
     * 
     * @description Generate next move with stack
     */
    public void generateNextMoveWithStack() {
        dfs.add(new Puzzle8State(sequence));
        generateNextMoveWithStack(dfs);
    }

    private void generateNextMoveWithStack(Stack<Puzzle8State> stack) {
        boolean flag = false;
        int count = 0;
        int[] goal = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        HashSet<String> hSet = new HashSet<>();
        while (!flag) {
            Puzzle8State cur = stack.pop();
            count++;
            Stack<Puzzle8State> nexStatesStack = generateNextMove(cur.sequence);
            for (Puzzle8State pState : nexStatesStack) {
                if (!hSet.contains(Arrays.toString(pState.sequence))) {
                    hSet.add(Arrays.toString(pState.sequence));
                    dfs.push(pState);
                    explored.add(pState);
                    if (explored.size() % 10000 == 0)
                        System.out.printf("popcount = %d StackSize =%d ExploredSize = %d\n", count,
                                stack.size(), hSet.size());
                    if (Arrays.equals(pState.sequence, goal)) {
                        flag = true;
                    }
                }
            }
        }
    }

    private int coordToInt(int x, int y) {
        int v = (x * 3) + y;
        return v;
    }

    private int[] swapInArray(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }

    private int getBlankPos(int[] seque) {
        int blankPos = -1;
        for (int i = 0; i < seque.length; i++) {
            if (seque[i] == 9) {
                blankPos = i;
                break;
            }
        }
        return blankPos;
    }
}
