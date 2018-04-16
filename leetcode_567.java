// Leetcode_567
// Permutation in String

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        if(m > n) return false;
        
        int[] freq = new int[26];
        for(int i = 0; i < m; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        
        if(equalCount(freq))
            return true;
        
        for(int i = m; i < n; i++) {
            freq[s2.charAt(i) - 'a']--;
            freq[s2.charAt(i - m) - 'a']++;   
            if(equalCount(freq))
                return true;
        }
        return false;
    }
    
    private boolean equalCount(int[] freq) {
        for(int item : freq)
            if(item != 0) return false;
        return true;
        
    }
}
