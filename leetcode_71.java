// Leetcode_71
// URL Simplifier

class Solution {
    public String simplifyPath(String path) {
        
        Set<String> skips = new HashSet(Arrays.asList("..", ".", ""));
        Stack<String> stk = new Stack<>();
        
        for(String str : path.split("/")) {
            if (str.equals("..") && !stk.isEmpty()) stk.pop();
            else if(!skips.contains(str)) stk.push(str);
        }
        
        StringBuffer bfr = new StringBuffer();
        while (!stk.isEmpty()) {
            bfr.insert(0, "/" + stk.pop());
        }
        
        String str = bfr.toString();
        return str.length() > 0? str : "/";
    }
}