import java.util.*;

public class GraphValidTree {
    Map<Integer, List<Integer>> adj = new HashMap<>();
    public boolean validTree(int n, int [][] edges){

        if (n == 0 || n == 1) return true;

        if (edges.length == 0) return false;

        for (var edge : edges) {
            var node1 = edge[0];
            var node2 = edge[1];
            adj.putIfAbsent(node1, new ArrayList<>());
            adj.putIfAbsent(node2, new ArrayList<>());
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        Set<Integer> visited = new HashSet<>();
        return dfs(edges[0][0], -1, visited) && visited.size() == n;
    }

    private boolean dfs(int n, int prev, Set<Integer> visited){
        if (visited.contains(n)) return false;
        visited.add(n);
        for (var neighbor : adj.get(n)) {
            if (neighbor == prev) continue;

            if (!dfs(neighbor, n, visited)) return false;
        }
        return true;
    }
}
