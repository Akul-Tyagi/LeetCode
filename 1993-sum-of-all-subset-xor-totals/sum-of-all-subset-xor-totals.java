class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }

    private int helper(int[] nums, int index, int curr){
        if(index==nums.length) return curr;

        int with = helper(nums, index+1, curr^nums[index]);
        int without = helper(nums, index+1, curr);

        return with + without;
    }
}