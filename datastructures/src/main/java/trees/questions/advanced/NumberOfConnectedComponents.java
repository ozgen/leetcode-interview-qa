package trees.questions.advanced;

public class NumberOfConnectedComponents {

    int[] parent;
    int[] weight;

    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1;
        }

        int result = n;
        for (int i = 0; i < edges.length; i++) {
            if (union(edges[i][0], edges[i][1]) == 1) {
                result--;
            }
        }

        return result;
    }

    private int find(int x) {
        if (x == parent[x]) return x;
        return find(parent[x]);
    }

    private int union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return 0;

        if (weight[rootX] > weight[rootY]) {
            parent[rootY] = rootX;
            weight[rootX] += weight[rootY];
        } else {
            parent[rootX] = rootY;
            weight[rootY] += weight[rootX];
        }
        return 1;
    }
}
