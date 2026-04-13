package all.tech.practice.ds.graph;

import java.util.*;

public class GraphExample {
    static class Graph {
        private final Map<Integer, List<Integer>> graph = new HashMap<>();
        // Your method
        // add linking between 2 nodes so each node will have a link to another node (vice versa).
        public void addEdge(int u, int v) {
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // undirected
        }

        public void printGraph() {
            for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        // Breadth First Search mechanism , We have to use Queue and will start reading from a starting node.
        public void bfs(int start) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited.add(start);

            System.out.print("BFS from " + start + ": ");
            while (!q.isEmpty()) {
                int node = q.poll();
                System.out.print(node + " ");

                for (int nei : graph.getOrDefault(node, Collections.emptyList())) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        q.add(nei);
                    }
                }
            }
            System.out.println();
        }

        // Depth First Search mechanism ,We have to use Either use Recursion or Stack and will start reading from a starting node.
        public void dfs(int start) {
            Set<Integer> visited = new HashSet<>();
            System.out.print("DFS from " + start + ": ");
            dfsHelper(start, visited);
            System.out.println();
        }

        private void dfsHelper(int node, Set<Integer> visited) {
            visited.add(node);
            System.out.print(node + " ");

            for (int nei : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(nei)) {
                    dfsHelper(nei, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        // -------------------------
        // INPUT 1: Basic graph
        // edges: (1-2), (1-3), (2-4), (3-4), (4-5)
        // -------------------------
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        System.out.println("Adjacency List:");
        g.printGraph();

        g.bfs(1);
        g.dfs(1);

        // -------------------------
        // INPUT 2: Another component
        // edges: (10-11), (11-12)
        // -------------------------
        g.addEdge(10, 11);
        g.addEdge(11, 12);

        System.out.println("\nAdjacency List after adding another component:");
        g.printGraph();

        g.bfs(10);
        g.dfs(10);

        // -------------------------
        // INPUT 3: Duplicate edge test (1-2 again)
        // -------------------------
        g.addEdge(1, 2);
        System.out.println("\nAfter adding duplicate edge (1-2) again:");
        g.printGraph();
    }
}