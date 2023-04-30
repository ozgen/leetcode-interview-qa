public class ContainerWithMostWater {

    /**
     * https://leetcode.com/problems/container-with-most-water/description/
     */
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(area, res);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ContainerWithMostWater withMostWater = new ContainerWithMostWater();

        int[] nums = {1,8,6,2,5,4,8,3,7};

        System.out.println(withMostWater.maxArea(nums));
    }
}
