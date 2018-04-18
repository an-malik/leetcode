\\ Leetcode_47
\\ permutations II
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permute = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> lst = new ArrayList<>();

        Arrays.sort(nums);
        helper(nums, lst, permute, used);
        return permute;
    }

    private void helper(int[] nums, List<Integer> lst, List<List<Integer>> permute, boolean[] used) {
        if(lst.size() == nums.length) {
            permute.add(new ArrayList<Integer>(lst));
            return;
        }

        for(int k = 0; k < nums.length; k++) {
            if(used[k] || (k > 0 && nums[k-1] == nums[k] && !used[k-1])) continue;

            used[k] = true;
            lst.add(nums[k]);

            helper(nums, lst, permute, used);

            used[k] = false;
            lst.remove(lst.size() - 1);
        }
    }
}
