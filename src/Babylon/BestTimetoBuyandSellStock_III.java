package Babylon;

public class BestTimetoBuyandSellStock_III {

    static void main() {
        BestTimetoBuyandSellStock_III s = new BestTimetoBuyandSellStock_III();
        System.out.println(s.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int [] left = new int[n];
        left[0] = 0;
        int [] right = new int[n];
        right[n - 1] = 0;
        int index = 0;
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - prices[index]);
            if (prices[i] < prices[index]) {
                index = i;
            }
        }
        index = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], prices[index] - prices[i]);
            if (prices[i] > prices[index]) {
                index = i;
            }
        }

        for (int i = 0; i < n; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }

        return profit;
    }


}
