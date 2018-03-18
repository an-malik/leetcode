// Leetcode_344
// Reverse String

class Solution {
    public String reverseString(String s) {
        StringBuffer sb = new StringBuffer();
        int i = s.length() - 1;
        while(i > -1) {
            sb.append(s.charAt(i--));
        }
        return sb.toString();
    }
}