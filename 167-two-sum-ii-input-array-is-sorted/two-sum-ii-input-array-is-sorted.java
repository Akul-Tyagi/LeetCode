class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while(nums[l] +nums[r]!=target){
            if(nums[l] +nums[r]>target){
                r--;
            } else {
                l++;
            }
        }

        int[] res = new int[2];
        res[0] = l+1;
        res[1] = r+1;
        return res;
    }
}