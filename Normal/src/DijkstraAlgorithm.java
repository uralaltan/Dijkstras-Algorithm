import java.util.*;

public class DijkstraAlgorithm {
    public static void dijkstra(WeightedGraph graph, int source) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] dist = new int[graph.getNumVertices()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        pq.offer(source);

        while (!pq.isEmpty()) {
            int curr = pq.poll();
            List<WeightedEdge> neighbors = graph.getNeighbors(curr);
            for (WeightedEdge edge : neighbors) {
                int neighbor = edge.dest();
                int weight = edge.weight();
                if (dist[curr] + weight < dist[neighbor]) {
                    dist[neighbor] = dist[curr] + weight;
                    pq.offer(neighbor);
                }
            }
        }

        for (int i = 0; i < graph.getNumVertices(); i++) {
            System.out.println("Shortest distance from source to vertex " + i + " is " + dist[i]);
        }
    }
}
