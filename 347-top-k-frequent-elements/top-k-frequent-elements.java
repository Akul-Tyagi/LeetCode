class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for(int element: nums){
            count.put(element, count.getOrDefault(element,0)+1);
        }

        List<Integer>[] bucket = new List[n+1];
        for(int i = 0; i <= n; i++) {
            bucket[i] = new ArrayList<>(); // Puts an empty list inside every bucket
        }

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }

        int[] ans = new int[k];
        int m =0;

        for(int i=n; i>=0;i--){
            for(int x: bucket[i]){
                ans[m] = x;
                m++;
            }
            if(m==k){
                return ans;
            }
        }

        return ans;
    }
}