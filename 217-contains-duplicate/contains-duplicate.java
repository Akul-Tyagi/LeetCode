class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int element: nums){
            count.put(element, count.getOrDefault(element,0)+1);
            if(count.get(element) > 1){
                return true;
            }
        }
        return false;
    }
}