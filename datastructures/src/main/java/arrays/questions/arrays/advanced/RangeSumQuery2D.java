package arrays.questions.arrays.advanced;

import java.util.ArrayList;
import java.util.List;

public class RangeSumQuery2D {
    /**
     * https://leetcode.com/problems/range-sum-query-2d-immutable/
     */

    class NumMatrix {
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
                return;
            sums = new int[matrix.length + 1][matrix[0].length + 1];

            for (int r = 0; r < matrix.length; r++) {
                int s = 0;
                for (int c = 0; c < matrix[0].length; c++) {
                    s += matrix[r][c];
                    if (r == 0) {
                        sums[r + 1][c + 1] = s;
                    } else {
                        int above = sums[r][c + 1];
                        sums[r + 1][c + 1] = above + s;
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (this.sums == null)
                return 0;
            int topRightX = row1 + 1;
            int topRightY = col2 + 1;
            int bottomLeftX = row2 + 1;
            int bottomLeftY = col1 + 1;
            int result = 0;
            if (row1 == 0 && col1 == 0) {
                result = sums[row2 + 1][col2 + 1];
            } else {
                result = sums[bottomLeftX][topRightY] - sums[topRightX - 1][topRightY] - sums[bottomLeftX][bottomLeftY - 1] + sums[topRightX -1][bottomLeftY -1];
            }
            return result;
        }
    }
}
