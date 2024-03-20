package dp;

public class MaxProfit {
    // You want to maximize your profit by choosing a single day to buy one stock and
    // choosing a different day in the future to sell that stock.

    // Input: prices = [7,1,5,3,6,4]
    // Output: 5
    public int maxProfit1(int[] prices){
        int min = prices[0];
        int diff = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min){
                min = prices[i];
            }

            if (diff < prices[i] - min){
                diff = prices[i] - min;
            }
        }
        return diff;
    }

    // On each day, you may decide to buy and/or sell the stock.
    // You can only hold at most one share of the stock at any time.
    // However, you can buy it then immediately sell it on the same day.

    // Input: prices = [7,1,5,3,6,4]
    // Output: 7

    // proposition: if a<b<c<d, the maximum profit is (b-a)+(c-b)+(d-c)=d-a
    // if a<b, c<d, c<a, the maximum profit is also (b-a)+(d-c)
    // the criteria is prices[i] > prices[i-1] only

    public int maxProfit2(int[] prices){

            int diff =0;
            for(int i =1;i<prices.length;i++)
            {
                if(prices[i]>prices[i-1])
                {
                    diff = diff +(prices[i]-prices[i-1]);
                }
            }
            return diff;

    }


    // Find the maximum profit you can achieve. You may complete at most two transactions.

    // Input: prices = [3,3,5,0,0,3,1,4]

    // Output: 6

    // Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
    // Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.

    public int maxProfit3(int[] prices){
        // find a day and partition it to left and right (two transactions)
        /*
        int diff = 0;

        for (int i = 0; i < prices.length; i++) {

            int leftMin = prices[0];
            int leftDiff = 0;

            int rightMax = prices[prices.length-1];
            int rightDiff = 0;

            for (int j = 0; j <= i; j++) {
                if (prices[j] < leftMin){
                    leftMin = prices[j];
                }
                if (leftDiff < prices[j] - leftMin){
                    leftDiff = prices[j] - leftMin;
                }
            }
            for (int j = prices.length - 1; j >= i ; j--) {
                if (prices[j] > rightMax){
                    rightMax = prices[j];
                }
                if (rightDiff < rightMax - prices[j]){
                    rightDiff = rightMax - prices[j];
                }
            }
            if (diff < leftDiff + rightDiff){
                diff = leftDiff + rightDiff;
            }
        }
        return diff;

        O(n^2) */

        // use space to change the time:

        int leftMin = prices[0];
        int leftDiff = 0;
        int[] left = new int[prices.length];

        int rightMax = prices[prices.length-1];
        int rightDiff = 0;
        int[] right = new int[prices.length];

        int diff = 0;
        // store the left profit
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leftMin){
                leftMin = prices[i];
            }

            if (leftDiff < prices[i] - leftMin){
                leftDiff = prices[i] - leftMin;
            }
            left[i] = leftDiff;

        }

        for (int i = prices.length - 1; i >= 0 ; i--) {
            if (prices[i] > rightMax){
                rightMax = prices[i];
            }

            if (rightDiff < rightMax - prices[i]){
                rightDiff = rightMax - prices[i];
            }
            right[i] = rightDiff;
        }

        for (int i = 0; i < prices.length; i++) {
            if (diff < left[i] + right[i]){
                diff = left[i] + right[i];
            }
        }
        return diff;
    }

    // k transaction, maximum profit

    // dp with tabulation

    public int maxProfit4(int k, int[] prices){

        int n = prices.length;
        int[][] dp = new int[k+1][n];

        if (n < 2) return 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                // maximum profit gained by two situations: skip and sell, then find the maximum
                dp[i][j] = Math.max(dp[i][j-1], formula(i, j, prices, dp));
            }
                    
        }
        return dp[k][n-1];
    }

    // dp[k-1][i] is the maximum profit in k-1 times, prices[x] - prices[i] is a trial to find the maximum profit
    public int formula(int k, int x, int[] prices, int[][] dp){
        int max = 0;
        for (int i = 0; i < x; i++) {
            max = Math.max(max, prices[x] - prices[i] + dp[k-1][i]);
        }
        return max;
    }

    // another solution in maxProfit4

    public int maxProfit(int k, int[] prices){

        int n = prices.length;
        int[][] dp = new int[k+1][n];

        if (n < 2) return 0;
        for (int i = 1; i <= k; i++) {
            int effectiveBuy = prices[0];
            for (int j = 1; j < n; j++) {
                // maximum profit gained by two situations: skip and sell, then find the maximum
                dp[i][j] = Math.max(dp[i][j-1], prices[j] - effectiveBuy);
                effectiveBuy = Math.min(effectiveBuy, prices[j] - dp[i-1][j]);
            }

        }
        return dp[k][n-1];
    }

    public static void main(String[] args) {
        MaxProfit test = new MaxProfit();
        int[] prices = {0,1,2,3,4,0,7,2,8,6,9};
        System.out.println(test.maxProfit4(2,prices));
    }

}
