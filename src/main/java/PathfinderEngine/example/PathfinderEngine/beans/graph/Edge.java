package PathfinderEngine.example.PathfinderEngine.beans.graph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Edge {
    private Node from;
    private Node to;
    private int weight;
}
