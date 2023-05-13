package trees.questions.advanced;

public class LongestIncreasingSubsequence {

    // todo review this solution and understand the implementation details...
    /**
     * https://leetcode.com/problems/longest-increasing-subsequence-ii/description/
     * @param nums
     * @param k
     * @return
     */

    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length;
        SegTree segTree = new SegTree(maxValue(nums) + 1);

        int ans = 1;
        for (int i = 0; i < n; i++) {
            int start = Math.max(1, nums[i] - k);
            int end = nums[i] - 1;
            int res = segTree.query(start, end);
            ans = Math.max(ans, 1 + res);
            segTree.update(nums[i], res + 1);
        }
        return ans;
    }

    private int maxValue(int[] nums) {
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);
        return max;
    }

}

class SegTree {
    int[] tree;
    int n;

    SegTree(int n) {
        this.n = n;
        tree = new int[4 * n];
    }

    public void update(int i, int val) {
        update(0, n - 1, i, 0, val);
    }

    private void update(int l, int r, int i, int node, int val) {
        if (l == r) {
            tree[node] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        if (i <= mid) update(l, mid, i, 2 * node + 1, val);
        else update(mid + 1, r, i, 2 * node + 2, val);
        tree[node] = Math.max(tree[node], Math.max(tree[2 * node + 1], tree[2 * node + 2]));
    }

    public int query(int st, int end) {
        return query(0, n - 1, st, end, 0);
    }

    private int query(int l, int r, int st, int end, int node) {
        if (l > end || r < st) return 0;
        if (l >= st && r <= end) {
            return tree[node];
        }
        int mid = l + (r - l) / 2;
        int res = query(l, mid, st, end, 2 * node + 1);
        res = Math.max(res, query(mid + 1, r, st, end, 2 * node + 2));
        return res;
    }
}

