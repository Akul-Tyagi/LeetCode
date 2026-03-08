class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> s = new HashSet<>();

        for(int i=0; i<n; i++){
            if(i>k){
                s.remove(nums[i-k-1]);
            }

            if(!s.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}