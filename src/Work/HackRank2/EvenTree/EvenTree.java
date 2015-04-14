package HackRank2.EvenTree;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EvenTree {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        in = new Scanner(new FileReader("src/HackRank2/EvenTree/EvenTree.txt"));

        HashMap<Integer, Node> totalNodes = new HashMap<>();

        int nodes = in.nextInt();
        int edges = in.nextInt();

        Node one = null;

        for (int i = 0; i < edges; i++) {
            int node = in.nextInt();
            int node2 = in.nextInt();

            Node self, target;

            if (!totalNodes.containsKey(node)) {
                self = new Node(node);
                totalNodes.put(node, self);
            } else {
                self = totalNodes.get(node);
            }

            if (!totalNodes.containsKey(node2)) {
                target = new Node(node2);
                totalNodes.put(node2, target);
            } else {
                target = totalNodes.get(node2);
            }

            if (one == null) {
                if (self.val == 1)
                    one = self;
                if (target.val == 1)
                    one = target;
            }

            self.nodes.add(target);
            target.nodes.add(self);
        }

        //clean tree
        clearNode(one);
//        System.out.println(one.countChild());

        int totalRemoved = 0;
    }

    public static void clearNode(Node base) {
        for (Node child : base.nodes) {
            child.nodes.remove(base);
            clearNode(child);
        }
    }

    public static class Node {

        public HashSet<Node> nodes;
        public int val;

        public Node(int v) {
            val = v;
            nodes = new HashSet<>();
        }

        public int countChild() {
            int total = nodes.size();

            for (Node n : nodes) {
                total += n.countChild();
            }

            return total;
        }
    }
}
