// Leetcode_26
// In-place removal of duplicates in a sorted integer array 

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int len = nums.length;
        if(len < 2) return len;
        
        int rIndex = 1;
        int i = 1;
        while (i < len) {
            if(nums[i] != nums[i - 1])
                nums[rIndex++] = nums[i];
            i++;
        }
        
        return rIndex;
    }
}