package PathfinderEngine.example.PathfinderEngine.beans.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<Node, List<Edge>> adjList = new HashMap<>();

    public void addNode(Node node){
        adjList.putIfAbsent(node,new ArrayList<>());
    }

    public void addEdge(Node from,Node to,int weight){
        adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(from, to, weight));
        adjList.computeIfAbsent(to, k -> new ArrayList<>()).add(new Edge(to, from, weight)); // For undirected graph
    }

    public Map<Node, List<Edge>> getAdjList() {
        return adjList;
    }

    public Node getNodeById(String fromId) {
    }
}
