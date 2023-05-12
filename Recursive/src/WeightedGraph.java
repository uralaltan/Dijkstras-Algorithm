import java.util.*;

public class WeightedGraph {
    private final Map<Integer, List<WeightedEdge>> adjList;
    private int numVertices;

    public WeightedGraph() {
        adjList = new HashMap<>();
        numVertices = 0;
    }

    public void addVertex(int v) {
        adjList.put(v, new ArrayList<>());
        numVertices++;
    }

    public void addEdge(int src, int dest, int weight) {
        WeightedEdge edge = new WeightedEdge(dest, weight);
        adjList.get(src).add(edge);

        edge = new WeightedEdge(src, weight);
        adjList.get(dest).add(edge);
    }

    public List<WeightedEdge> getNeighbors(int v) {
        return adjList.get(v);
    }

    public int getNumVertices() {
        return numVertices;
    }
}

