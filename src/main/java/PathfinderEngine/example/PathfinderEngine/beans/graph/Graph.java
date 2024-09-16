package PathfinderEngine.example.PathfinderEngine.beans.graph;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Component
public class Graph {
    private final Map<String, Node> nodeMap = new HashMap<>();
    private final Map<Node, List<Edge>> adjList = new HashMap<>();

    public void addNode(Node node) {
        nodeMap.putIfAbsent(node.getId(), node);
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    public Node getNodeById(String id) {
        return nodeMap.get(id);
    }

    public void addEdge(Node from, Node to, int weight) {
        adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(from, to, weight));
        adjList.computeIfAbsent(to, k -> new ArrayList<>()).add(new Edge(to, from, weight)); // For undirected graph
    }
}
