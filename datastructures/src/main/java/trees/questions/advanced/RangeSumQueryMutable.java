package trees.questions.advanced;

public class RangeSumQueryMutable {
    /**
     * https://leetcode.com/problems/range-sum-query-mutable/
     */

    class NumArray {

        STree root;

        public NumArray(int[] nums) {
            root = STree.build(nums, 0, nums.length - 1);
        }

        public void update(int index, int val) {
            root.update(index, val);
        }

        public int sumRange(int left, int right) {
            return root.rangeQuery(left,right);
        }

    }


}

class STree {
    int sum;
    int L;
    int R;
    STree right;
    STree left;

    public STree(int total, int l, int r) {
        sum = total;
        L = l;
        R = r;
        right = null;
        left = null;
    }

    public static STree build(int[] nums, int l, int r) {
        if (l == r) {
            return new STree(nums[l], l, r);
        }

        int M = (l + r) / 2;
        STree root = new STree(0, l, r);
        root.left = STree.build(nums, l, M);
        root.right = STree.build(nums, M + 1, r);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public void update(int index, int val) {
        if (this.L == this.R) {
            this.sum = val;
            return;
        }

        int M = (this.L + this.R) / 2;
        if (index > M) {
            this.right.update(index, val);
        } else {
            this.left.update(index, val);
        }
        this.sum = this.left.sum + this.right.sum;
    }

    public int rangeQuery(int l, int r) {
        if (l == L && r == R) {
            return this.sum;
        }

        int M = (this.L + this.L) / 2;
        if (L > M) {
            return this.right.rangeQuery(L, R);
        } else if (R <= M) {
            return this.left.rangeQuery(L, R);
        } else {
            return (this.left.rangeQuery(L, M) + this.right.rangeQuery(M + 1, R));
        }
    }
}
