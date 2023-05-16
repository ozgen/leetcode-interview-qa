package graphs.questions.advanced;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleVI {

    /**
     * https://leetcode.com/problems/course-schedule-iv/description/
     */

    Boolean[][] dp;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Boolean> result = new LinkedList();

        dp = new Boolean[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : prerequisites)
            graph.get(edge[1]).add(edge[0]);

        for (int[] query : queries) {
            if (dfs(query[0], query[1], graph))
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }

    private boolean dfs(int end, int start, List<List<Integer>> graph) {
        if (start == end)
            return true;

        if (dp[start][end] != null)
            return dp[start][end];

        for (int neighbour : graph.get(start))
            if (dfs(end, neighbour, graph))
                return dp[start][end] = true;

        return dp[start][end] = false;
    }

    public static void main(String[] args) {
        CourseScheduleVI vi = new CourseScheduleVI();
        int[][] pre = new int[][]{{2, 3}, {2, 1}, {0, 3}, {0, 1}};
        int[][] que = new int[][]{{0, 1}, {0, 3}, {2, 3}, {3, 0}, {2, 0}, {0, 2}};
        vi.checkIfPrerequisite(4, pre, que);
    }
//    3, 1, 0, 2
}
