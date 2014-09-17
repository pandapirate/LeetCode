package Graph;

import java.util.HashMap;

/**
 * Created by Kevin on 9/16/2014.
 */
public class CloneGraph {

    public static HashMap<UndirectedGraphNode, UndirectedGraphNode> map;

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        map = new HashMap<>();
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null)
            return node;
        else if (map.containsKey(node))
            return map.get(node);

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);

        for (UndirectedGraphNode n : node.neighbors) {
            if (n == node) {
                clone.neighbors.add(clone);
            } else {
                clone.neighbors.add(clone(n));
            }
        }

        return clone;
    }
}
