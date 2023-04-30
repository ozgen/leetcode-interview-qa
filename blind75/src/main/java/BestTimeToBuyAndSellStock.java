public class BestTimeToBuyAndSellStock {
    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
     */

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int l = 0;
        int r = 1;
        int mp = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int p = prices[r] - prices[l];
                mp = Math.max(p, mp);
                r++;
            } else {
                l = r;
                r++;
            }
        }
        return mp;
    }
}
