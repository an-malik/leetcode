// Leetcode_153
// Find Minimum in rotated sorted array

class Solution {
    public int findMin(int[] nums) {
        int index = findPivot(nums, 0, nums.length - 1);
        if (index == -1)
            return nums[0];
        else
            return nums[index];
        // return index;
    }
    
    private int findPivot(int[] nums, int s, int e){
        if (s > e) return -1;
        if (s == e) return s;
        
        int mid = (e + s) / 2;
        int val = nums[mid];
        if(mid > s && val < nums[mid - 1]) {
            return mid;
        }
        if(mid < e && val > nums[mid + 1]) {
            return (mid + 1);
        }
        if(nums[e] > val) {
            return findPivot(nums, s, mid - 1);
        } else {
            return findPivot(nums, mid + 1, e);
        }
    }
}