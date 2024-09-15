package PathfinderEngine.example.PathfinderEngine.controllers;

import PathfinderEngine.example.PathfinderEngine.beans.algorithms.Dijkstra;
import PathfinderEngine.example.PathfinderEngine.beans.graph.Graph;
import PathfinderEngine.example.PathfinderEngine.beans.graph.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GraphController {
    @Autowired
    private Graph graph;


    @PostMapping("/addNode")
    public void addNode(@RequestBody Node node) {
        graph.addNode(node);
    }

    @PostMapping("/addEdge/{fromId}/{toId}/{weight}")
    public void addEdge(@RequestParam String fromId, @RequestParam String toId, @RequestParam int weight) {
        Node from = graph.getNodeById(fromId);
        Node to = graph.getNodeById(toId);
        if (from != null && to != null) {
            graph.addEdge(from, to, weight);
        } else {
            throw new RuntimeException("One or both nodes not found");
        }
    }
}
