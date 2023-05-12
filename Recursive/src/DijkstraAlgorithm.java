import java.util.*;

public class DijkstraAlgorithm {
    private static final int INFINITY = Integer.MAX_VALUE;

    public static void dijkstra(WeightedGraph graph, int source, int dest) {
        int[] dist = new int[graph.getNumVertices()];
        Arrays.fill(dist, INFINITY);
        dist[source] = 0;

        dijkstraHelper(graph, source, dest, dist);

        System.out.println("Shortest distance from source to destination is " + dist[dest]);
    }

    private static void dijkstraHelper(WeightedGraph graph, int curr, int dest, int[] dist) {
        if (curr == dest) {
            return;
        }

        List<WeightedEdge> neighbors = graph.getNeighbors(curr);
        for (WeightedEdge edge : neighbors) {
            int neighbor = edge.dest();
            int weight = edge.weight();
            if (dist[curr] + weight < dist[neighbor]) {
                dist[neighbor] = dist[curr] + weight;
                dijkstraHelper(graph, neighbor, dest, dist);
            }
        }
    }
}
