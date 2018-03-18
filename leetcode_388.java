// Leetcode_388
// Longest Absolute File Path

class Solution {
    public int lengthLongestPath(String input) {
        
        Stack<Integer> stk = new Stack<>();
        String[] paths = input.split("\n");
        
        int maxLen = 0;
        int totalLen = 0;
        for(String curr : paths) {
            int level = getLevel(curr);
            int len = curr.replace("\t", "").length() + 1;
            int item = 0;
            while(!stk.isEmpty() && stk.size() >= level) {
                item = stk.pop();
                totalLen -= item;
            }
            
            totalLen += len;
            stk.push(len);
            
            if(curr.indexOf(".") >= 0 && totalLen > maxLen) {
                maxLen = totalLen;
            }
        }
        
        return maxLen > 0 ? maxLen - 1 : maxLen;
    }
    
    private int getLevel(String path) {
        return path.length() - path.replace("\t","").length() + 1;
    }
}