public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minimumPrice = prices[0];
        int maximumProfit = 0;

        for (int price : prices) {
            maximumProfit = Math.max(maximumProfit, price - minimumPrice);
            minimumPrice = Math.min(minimumPrice, price);
        }

        return maximumProfit;
    }    
}
