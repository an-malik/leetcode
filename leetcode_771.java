// Leetcode_771
// Jewels and Stones

class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] freq = new boolean[256];
        for(char ch : J.toCharArray())
            freq[ch - '0'] = true;
    
        int count = 0;
        for(char ch : S.toCharArray())
            if(freq[ch - '0']) count++;
        
        return count;
    }
}
