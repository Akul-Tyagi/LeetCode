class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int rp = n-1;
        int lp = 0;

        while(lp<=rp){
            int mid = (lp+rp)/2;
            if(nums[mid]<target){
                lp = mid+1;
            } else if (nums[mid]> target){
                rp = mid-1;
            } else if(nums[mid]==target){
                return mid;
            }
        }
        return -1;
    }
}