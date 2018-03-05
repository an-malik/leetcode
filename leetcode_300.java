// Leetcode_300
// Longest Increasing Subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if(len == 0) return 0;
        
        int[] dp = new int[len];
        for(int i = 0; i < len; i++)
            dp[i] = 1;
        
        int maxVal = 1;
        
        for(int i = 1; i < len; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j] && dp[i] < (dp[j] + 1))
                    dp[i] = dp[j] + 1;
            }
            
            if(maxVal < dp[i])
                maxVal = dp[i];
        }
        
        return maxVal;
    }
}