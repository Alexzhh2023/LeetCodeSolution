package Babylon;

public class BestTimetoBuyandSellStock_II {

    static void main() {
        BestTimetoBuyandSellStock_II s = new BestTimetoBuyandSellStock_II();
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(s.maxProfit(new int[]{1,2,3,4,5}));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        int index = 0;
        for (int i = 1; i <= prices.length; i++) {
             if (i == prices.length  || prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - prices[index];
                index = i;
            }
        }
        return profit;
    }
}
