class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right =0;

        for(int i=0; i<n;i++){
            left = Math.max(left,nums[i]);
            right += nums[i];
        }

        while(left<right){
            int mid = left + (right-left)/2;
            int splits = 1;
            int curr=0;

            for(int i=0; i<n;i++){
                if(curr+nums[i]>mid){
                    splits++;
                    curr=nums[i];
                } else{
                    curr += nums[i];
                    }
            }
            if(splits>k){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        return left;
    }
}