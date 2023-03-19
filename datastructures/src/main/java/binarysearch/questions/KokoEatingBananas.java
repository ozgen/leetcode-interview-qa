package binarysearch.questions;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {

            int mid = (low + high) / 2;
            int spentHour = 0;
            for (int p : piles) {
                spentHour += Math.ceil((double) p / mid);
            }

            if (spentHour <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;

    }


    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
        int[]piles = new int[]{30,11,23,4,20};
        int h = 5;

        int speed = kokoEatingBananas.minEatingSpeed(piles, h);
        System.out.println(speed);
    }
}
