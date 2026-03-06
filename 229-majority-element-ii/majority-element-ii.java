class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int m = n/3;

        if(n<=1){
            for(int y: nums){
                ans.add(y);
            }
            return ans;
        }

        HashMap<Integer, Integer> count = new HashMap<>();

        for(int x: nums){
            count.put(x,count.getOrDefault(x,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: count.entrySet()){
            if(entry.getValue() > m){
                ans.add(entry.getKey());
            } else{
                continue;
            }
        }

        return ans;
    }
}