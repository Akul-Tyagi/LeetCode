class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(res, new ArrayList<>(), used, nums);
        return res;
    }
    public void backtrack(List<List<Integer>> res, ArrayList<Integer> temp, boolean[] used, int[] nums){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        } else{
            for(int i=0; i<nums.length; i++){
                if(i>0 && nums[i]==nums[i-1] && !used[i-1] || (used[i])) continue;
                temp.add(nums[i]);
                used[i] = true;
                backtrack(res, temp, used, nums);
                temp.remove(temp.size()-1);
                used[i] = false;
            }
        }
    }
}