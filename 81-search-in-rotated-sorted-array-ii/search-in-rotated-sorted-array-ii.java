class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int lp = 0;
        int rp = n-1;

        while(lp<=rp){
            int mid = lp+(rp-lp)/2;

            if(nums[mid] == target){
                return true;
            }
            
            if(nums[mid]<nums[rp] || nums[mid]<nums[lp]){
                if(target>nums[mid] && target<=nums[rp]){
                    lp = mid+1;
                } else{
                    rp = mid-1;
                }
            } else if (nums[mid] > nums[lp] || nums[mid] > nums[rp]) {
                if (target < nums[mid] && target >= nums[lp]) {
                    rp = mid - 1;
                } else {
                    lp = mid + 1;
                }
            } else{
                rp--;
            }
        }
        return false;
    }
}