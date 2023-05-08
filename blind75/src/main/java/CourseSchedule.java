import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    /**
     * https://leetcode.com/problems/course-schedule/
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visit[i] == 0) {
                if(isCycle(adj, visit, i)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCycle(List<List<Integer>> adj, int[] visit, int i) {
        if(visit[i] == 2){
            return true;
        }
        visit[i] = 2;
        for(int j = 0; j < adj.get(i).size(); j++){
            if(isCycle(adj, visit, adj.get(i).get(j))){
                return true;
            }
        }
        visit[i]=1;
        return false;
    }

}
