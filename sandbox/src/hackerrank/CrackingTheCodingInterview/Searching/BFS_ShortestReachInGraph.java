package hackerrank.CrackingTheCodingInterview.Searching;

import java.util.ArrayDeque;
import java.util.HashSet;

//https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem

public class BFS_ShortestReachInGraph {
    private static final int EDGE_WEIGHT = 6;

    public static void main(String[] args) {
        //first sample input from site
        int numNodes = 4;
        int numEdges = 2;
        /* Create Nodes */
        Node[] node = new Node[numNodes + 1]; // node "i" will be at index "i"
        node[0] = null;
        for (int i = 1; i <= numNodes; i++) {
            node[i] = new Node(i);
        }

        /* Connect Nodes */
        //1 2
        node[1].addNeighbor(node[2]);
        //1 3
        node[1].addNeighbor(node[3]);

        /* Create MST */
        //node 1 is starting node
        int start = 1;
        findDistances(node[start]);


        /* Print results */
        for (int i = 1; i <= numNodes; i++) {
            if (i != start) {
                System.out.print(node[i].distance + " ");
            }
        }
        System.out.println();

        //sample input 2 from site
        //3 1
        //2 3
        //2
    }


    /* Uses BFS to find minimum distance of each Node from "start".
       Can use BFS instead of Dijkstra's Algorithm since edges are equally weighted. */
    private static void findDistances(Node start)  {
        if (start == null) {
            return;
        }
        ArrayDeque<Node> deque = new ArrayDeque<>(); // use deque as a queue
        start.distance = 0;
        deque.add(start);
        while (!deque.isEmpty()) {
            Node curr = deque.remove();
            for (Node neighbor : curr.neighbors) {
                if (neighbor.distance == -1) { // meaning it's unvisited
                    neighbor.distance = curr.distance + EDGE_WEIGHT;
                    deque.add(neighbor);
                }
            }
        }
    }

    /* Implementation of an UNDIRECTED graph */
    public static class Node {
        public final int id; // each Node will have a unique ID
        public int distance; // Also tells us if Node has been visited (-1 means unvisited)
        public HashSet<Node> neighbors;

        public Node(int id) {
            this.id = id;
            distance = -1;
            neighbors = new HashSet<>();
        }

        public void addNeighbor(Node neighbor) {
            neighbors.add(neighbor);
            neighbor.neighbors.add(this);
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            } else if (other == null || !(other instanceof Node)) {
                return false;
            }
            Node otherNode = (Node) other;
            return this.id == otherNode.id;
        }

        @Override
        public int hashCode() {
            return id; // simple and effective
        }
    }
}
