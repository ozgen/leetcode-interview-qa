package dynamicproggamming.questions.advanced;

import java.util.HashMap;
import java.util.Map;

public class ShortestCommonSupersequence {
    /**
     * https://leetcode.com/problems/shortest-common-supersequence/
     */
        // this solution exceed time limit...
    public String shortestCommonSupersequence(String str1, String str2) {
        Map<String, String> cache = new HashMap();
        return dfs(str1, str2, 0, 0, cache);
    }

    private String dfs(String s1, String s2, int i1, int i2, Map<String, String> cache) {
        if (i1 == s1.length() && i2 == s2.length()) return "";
        if (i1 == s1.length() || i2 == s2.length()) {
            if (i1 == s1.length()) {
                return s2.substring(i2);
            } else {
                return s1.substring(i1);
            }
        }

        String key = i1 + "-" + i2;
        if (cache.containsKey(key)) return cache.get(key);
        String res;
        if (s1.charAt(i1) == s2.charAt(i2)) {
            res = s1.charAt(i1) + dfs(s1, s2, i1 + 1, i2 + 1, cache);
            cache.put(key, res);
        } else {
            String res1 = s1.charAt(i1) + dfs(s1, s2, i1 + 1, i2, cache);
            String res2 = s2.charAt(i2) + dfs(s1, s2, i1, i2 + 1, cache);

            if (res1.length() <= res2.length()) {
                res = res1;
            } else {
                res = res2;
            }

        }
        cache.put(key, res);
        return res;
    }


    public String shortestCommonSupersequence2(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Create a 2D array to store the lengths of common subsequences
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Build the shortest common supersequence using the dp array
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Append remaining characters from str1 and str2
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        // Reverse the result and return the shortest common supersequence
        return sb.reverse().toString();
    }
}
