package graphs.questions.advanced;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule_II {
    /**
     * https://leetcode.com/problems/course-schedule-ii/
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
        }
        int[] visit = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {
                if (dfs(adj, visit, i, res)) {
                    return new int[]{};
                }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(List<List<Integer>> adj, int[] visit, int course, List<Integer> res) {
        if (visit[course] == 2) return true;
        visit[course] = 2;
        for (int i = 0; i < adj.get(course).size(); i++) {
            if (visit[adj.get(course).get(i)] != 1) {
                if (dfs(adj, visit, adj.get(course).get(i), res)) return true;
            }
        }
        visit[course] = 1;
        res.add(course);
        return false;
    }
}
