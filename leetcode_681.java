// Leetcode_681
// Next Closest Time

class Solution {
    public String nextClosestTime(String time) {
        
        String[] temp = time.split(":");
        Integer now = Integer.parseInt(temp[0]) * 60;
        now += Integer.parseInt(temp[1]);
        
        Set<Integer> digits = new HashSet<>();
        for(char ch : time.toCharArray()) {
            if(ch != ':')
                digits.add(ch - '0');
        }
        
        Integer cur = now;
        boolean valid = true;
        while (true) {
            cur = (cur + 1) % (24 * 60);
            int[] newDigits = new int[]{cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
            valid = true;
            for (int d: newDigits) {
                if (!digits.contains(d)) {
                    valid = false;
                    break;
                }
            }
    
            if(valid)
                return String.format("%02d:%02d", cur / 60, cur % 60);
        }
    }
}