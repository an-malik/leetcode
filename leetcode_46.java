// Leetcode_46
// Permutations

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> allPerm = new ArrayList<>();
        backtrack(nums, allPerm, 0);
        return allPerm;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> allPerm, int s) {
        if (s >= nums.length - 1) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            allPerm.add(list);
            return;
        }
        
        for(int i = s; i < nums.length; i++) {
            swap(nums, s, i);
            backtrack(nums, allPerm, s + 1);
            swap(nums, s, i);
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}