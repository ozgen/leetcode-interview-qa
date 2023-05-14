package graphs.questions.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMaxProbability {
    /**
     * https://leetcode.com/problems/path-with-maximum-probability/description/
     */

    class Pair {
        int node;
        double prob;

        public Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 1));
        double[] probArr = new double[n];
        Arrays.fill(probArr, Double.MIN_VALUE);
        probArr[start] = 1;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int node = pair.node;
            double prob = pair.prob;
            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                double adjProb = p.prob;
                double calcProb = adjProb * prob;
                if (calcProb > probArr[adjNode]) {
                    probArr[adjNode] = calcProb;
                    q.add(new Pair(adjNode, calcProb));
                }
            }
        }
        return probArr[end] == Double.MIN_VALUE ? 0 : probArr[end];
    }
}
