class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> n = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]== nums[i-1]){
                continue;
            }
            int lp=i+1;
            int rp=nums.length -1;

            while(lp<rp){
                int total = nums[i] + nums[lp] + nums[rp];

                if(total>0){
                    rp--;
                } else if(total<0){
                    lp++;
                } else{
                    n.add(Arrays.asList(nums[i],nums[lp],nums[rp]));
                    lp++;

                    while(nums[lp]==nums[lp-1]&& lp<rp){
                        lp++;
                    }
                }
            }
        }
        return n;
    }
}