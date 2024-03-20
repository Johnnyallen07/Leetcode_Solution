package solutions;

import utils.Node;

import java.util.*;

public class CXXXIII {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        List<Node> node1Neighbor = Arrays.asList(node2, node4);
        List<Node> node2Neighbor = Arrays.asList(node1, node3);
        List<Node> node3Neighbor = Arrays.asList(node2, node4);
        List<Node> node4Neighbor = Arrays.asList(node1, node3);
        node1.neighbors = node1Neighbor;
        node2.neighbors = node2Neighbor;
        node3.neighbors = node3Neighbor;
        node4.neighbors = node4Neighbor;
        Node test = new CXXXIII().cloneGraph(node1);
    }

    /*

    private Set<Integer> nodeList = new HashSet<>();
    public Node cloneGraph(Node node) {
        Node clone = new Node();
        dfs(node, clone);
        return clone;
    }

    private void dfs(Node curNode, Node clone){
        if (nodeList.contains(curNode.val)){
            return;
        }
        clone.val = curNode.val;
        nodeList.add(curNode.val);
        addNeighbor(curNode, clone);
        List<Node> neighbors = curNode.neighbors;
        List<Node> cloneNeighbors = clone.neighbors;
        for (int i = 0; i < neighbors.size(); i++) {
            dfs(neighbors.get(i), cloneNeighbors.get(i));
        }
    }

    private void addNeighbor(Node curNode, Node clone){
        List<Node> cloneNeighbors = new ArrayList<>();
        for (Node neighbor : curNode.neighbors){
            cloneNeighbors.add(new Node(neighbor.val));
        }
        clone.neighbors = cloneNeighbors;
    }

     */

    Map<Node, Node> map = new HashMap<>();
    // the reference is the key to the problem
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor))
                newNode.neighbors.add(cloneGraph(neighbor));
            else
                newNode.neighbors.add(map.get(neighbor));
        }
        return newNode;
    }
}
