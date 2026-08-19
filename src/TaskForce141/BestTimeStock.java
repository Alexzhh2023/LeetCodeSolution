package TaskForce141;

public class BestTimeStock {
    static void main() {
        BestTimeStock bestTimeStock = new BestTimeStock();
        System.out.println(bestTimeStock.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int maxPrice = prices[prices.length - 1];

        for (int i = prices.length - 2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
        }
        return maxProfit;
    }
}
