package dynamicproggamming.questions;

public class UniquePaths_II {
    /**
     * https://leetcode.com/problems/unique-paths-ii/
     *
     * @param obstacleGrid
     * @return
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int ROWS = obstacleGrid.length;
        int COLS = obstacleGrid[0].length;

        if (obstacleGrid[ROWS - 1][COLS - 1] == 1) return 0;

        int[] curRow = new int[COLS];
        curRow[COLS - 1] = 1;

        for (int r = ROWS - 1; r >= 0; r--) {

            for (int c = COLS - 1; c >= 0; c--) {
                if (obstacleGrid[r][c] == 1) {
                    curRow[c] = 0;
                } else if (c + 1 < COLS) {
                    curRow[c] = curRow[c + 1] + curRow[c];
                }
            }
        }
        return curRow[0];
    }


    public static void main(String[] args) {
        UniquePaths_II uniquePaths_ii = new UniquePaths_II();

        int[][] og = new int[][]{{0, 0}, {0, 1}, {0, 0}};
        int paths = uniquePaths_ii.uniquePathsWithObstacles(og);
        System.out.println(paths);
    }
}
