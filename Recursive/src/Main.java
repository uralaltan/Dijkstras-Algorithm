public class Main {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph();

        // add vertices to the graph
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        // add edges to the graph
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 6);
        graph.addEdge(2, 3, 7);

        DijkstraAlgorithm.dijkstra(graph, 0, 3);
    }
}
