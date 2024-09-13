package PathfinderEngine.example.PathfinderEngine.beans.graph;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Node {
    private String id;
    private String name;
}
