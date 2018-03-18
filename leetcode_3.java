// Leetcode_3
// Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String str) {
        
        int[] freq = new int[256];
        for(int i = 0; i < 256; i++)
            freq[i] = -1;
        
        int s = 0, e = 0;
        int maxLen = 0;
        int len = str.length();
        while(e < len && s <= e) {
            char ch = str.charAt(e);
            if(freq[ch] > -1) 
                s = s > freq[ch] ? s : freq[ch];
            
            freq[ch] = e + 1;
            maxLen = (e - s + 1) > maxLen ? e - s + 1 : maxLen;
            e++;
        }
        
        return maxLen;
    }
}