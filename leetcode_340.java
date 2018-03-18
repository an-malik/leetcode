// Leetcode_340
// Longest Substring with At Most K Distinct Characters

class Solution {
    public int lengthOfLongestSubstringKDistinct(String str, int k) {
        
        int s = 0, max = 0;
        int difCount = 0;
        int[] freq = new int[256];
        for(int e = 0; e < str.length(); e++) {
            char eCh = str.charAt(e);
            if(freq[eCh] == 0)
                difCount++;
            freq[eCh]++;
            
            while(difCount > k) {
                int sCh = str.charAt(s);
                freq[sCh]--;
                if(freq[sCh] == 0)
                    difCount--;
                s++;
            }
            
            max = max > e - s + 1 ? max : e - s + 1;
        }
        
        return max;
    }
}