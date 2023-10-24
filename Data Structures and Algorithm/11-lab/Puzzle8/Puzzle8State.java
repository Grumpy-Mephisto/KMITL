import java.util.Arrays;

public class Puzzle8State {
    public int[] sequence;

    public Puzzle8State(int[] newSeq) {
        this.sequence = newSeq;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Puzzle8State other = (Puzzle8State) obj;
        return Arrays.equals(sequence, other.sequence);
    }

    public boolean isGoal(int[] seq) {
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] != i) {
                return false;
            }
        }
        return true;
    }
}
