package dynamicprogramming;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        int[] dp = new int[n];

        int max = prices[n - 1];
        for(int i = n - 2; i >= 0; i--)
        {
            dp[i] = Math.max(max - prices[i], dp[i + 1]);
            System.out.println(max - prices[i]);
            if(prices[i] > max)
                max = prices[i];
            //System.out.print(i + ": " + dp[i] + "  ");
        }
        System.out.println();
        int min = prices[0];
        max = 0;
        for(int i = 0; i < n; i++)
        {
            max = Math.max(prices[i] - min + dp[i], max);
            if(prices[i] < min)
                min = prices[i];
        }
        return max;
    }
}
