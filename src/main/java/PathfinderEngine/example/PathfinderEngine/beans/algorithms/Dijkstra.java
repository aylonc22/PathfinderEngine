package PathfinderEngine.example.PathfinderEngine.beans.algorithms;



import PathfinderEngine.example.PathfinderEngine.beans.graph.Edge;
import PathfinderEngine.example.PathfinderEngine.beans.graph.Graph;
import PathfinderEngine.example.PathfinderEngine.beans.graph.Node;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class Dijkstra {
    public Map<Node, Integer> findShortestPath(Graph graph, Node start) {
        Map<Node, Integer> distances = new HashMap<>();
        PriorityQueue<NodeDistance> pq = new PriorityQueue<>(Comparator.comparingInt(NodeDistance::getDistance));
        Set<Node> visited = new HashSet<>();

        for (Node node : graph.getAdjList().keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new NodeDistance(start, 0));

        while (!pq.isEmpty()) {
            NodeDistance currentNodeDist = pq.poll();
            Node currentNode = currentNodeDist.getNode();
            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);

            for (Edge edge : graph.getAdjList().get(currentNode)) {
                if (visited.contains(edge.getTo())) continue;
                int newDist = distances.get(currentNode) + edge.getWeight();
                if (newDist < distances.get(edge.getTo())) {
                    distances.put(edge.getTo(), newDist);
                    pq.add(new NodeDistance(edge.getTo(), newDist));
                }
            }
        }
        return distances;
    }

    @Data
    @AllArgsConstructor
    private static class NodeDistance{
        private final Node node;
        private final int distance;

    }
}