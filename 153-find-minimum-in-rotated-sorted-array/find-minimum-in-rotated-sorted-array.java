class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lp = 0;
        int rp = n-1;

        while(lp<rp){
            int mid= lp+(rp-lp)/2;
            if(nums[mid]>nums[rp]){
                lp = mid+1;
            } else{
                rp = mid;
            }
        }
        return nums[lp];
    }
}