// Leetcode_15
// 3 sum problem - a + b + c  = 0

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return result;
        
        Arrays.sort(nums);
        for(int i = 0; i < len - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int target = -1 * nums[i];

                int s = i + 1;
                int e = len - 1;

                while(s < e) {
                    int sum = nums[s] + nums[e];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[s], nums[e]));

                        while(s < e && nums[s] == nums[s+1]) 
                            s++;

                        while(s < e && nums[e] == nums[e-1]) 
                            e--;
                        
                        s++;
                        e--;
                    }

                    else if(sum > target) e--;
                    else s++;
                }
            }
        }
        
        return result;
    }
}