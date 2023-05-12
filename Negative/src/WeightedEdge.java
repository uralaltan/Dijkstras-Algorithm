public class WeightedEdge {
    private final int dest;
    private int weight;

    public WeightedEdge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public int getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
