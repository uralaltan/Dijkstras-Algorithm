import java.util.*;

public class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(WeightedGraph graph, int source) {
        int n = graph.getNumVertices();
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[source] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(n, Collections.reverseOrder(Comparator.comparingInt(i -> dist[i])));
        pq.offer(source);

        while (!pq.isEmpty()) {
            int curr = pq.poll();

            if (dist[curr] == INF) {
                break;
            }

            List<WeightedEdge> neighbors = graph.getNeighbors(curr);

            for (WeightedEdge edge : neighbors) {
                int neighbor = edge.getDest();
                int weight = edge.getWeight();
                if (dist[neighbor] > dist[curr] + weight) {
                    dist[neighbor] = dist[curr] + weight;
                    pq.offer(neighbor);
                }
            }

            if (!pq.isEmpty()) {
                int next = pq.peek();
                int roadToFarthest = dist[curr] - dist[next] + 1;
                dist[curr] = dist[next] - 1;
                graph.setWeight(curr, next, roadToFarthest);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Shortest distance from source to vertex " + i + " is " + dist[i]);
        }
    }
}
