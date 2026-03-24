class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> s = new HashSet<>();
        int ans =0;

        for(int x: nums){
            boolean isNew = s.add(x);

            if(!isNew){
                ans = x;
            }
        }
        return ans;
    }
}