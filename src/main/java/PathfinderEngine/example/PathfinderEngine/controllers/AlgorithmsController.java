package PathfinderEngine.example.PathfinderEngine.controllers;

import PathfinderEngine.example.PathfinderEngine.beans.graph.Node;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AlgorithmsController {
    @GetMapping("/Dijkstra")
    public Map<Node,Integer> dijkstraAlgo(){

    }
}
