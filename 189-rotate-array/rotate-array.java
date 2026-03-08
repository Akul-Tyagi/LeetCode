class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        LinkedList<Integer> ll = new LinkedList<>();

        for(int elements: nums){
            ll.add(elements);
        }

        int count = 0;

        while(count!=k){
            int element = ll.removeLast();
            ll.addFirst(element);
            count++;
        }

        int i  =0;
        for(int elements: ll){
            nums[i++] = elements;
        }
    }
}