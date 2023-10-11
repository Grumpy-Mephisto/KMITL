public class PrimEdge implements Comparable<PrimEdge> {
    public int u, v, weight;

    public PrimEdge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int getters() {
        return this.weight;
    }

    @Override
    public int compareTo(PrimEdge other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", this.u, this.v, this.weight);
    }
}
