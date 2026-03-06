class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int left = 1;
        int right = 1;

        int[] ans = new int[n];

        for(int i=0; i<n;i++){
            ans[i] = left;
            left = left*nums[i];
        }

        for(int i=r; i>=0; i--){
            ans[i] = ans[i]*right;
            right = right*nums[i];
        }
        return ans;
    }
}