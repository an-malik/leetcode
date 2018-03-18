// Leetcode_448
// Find All Numbers Disappeared in an Array

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        for(int num : nums) {
            if(num < 0)
                num *= -1;
            
            if(nums[num - 1] > 0)
                nums[num - 1] *= -1;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0)
                list.add(i+1);
        }
        
        return list;
    }
}