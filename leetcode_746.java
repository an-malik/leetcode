\\ Leetcode_746
\\ Min cost climbing stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            if(i < 2)
                dp[i] = cost[i];
            else
                dp[i] = Math.min(dp[i-2], dp[i-1]) + (i == n ? 0 : cost[i]);
        }

        return dp[n];
    }
}
