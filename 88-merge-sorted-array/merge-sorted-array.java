class Solution {
    public void merge(int[] nums1, int n, int[] nums2, int m) {
        int x = nums1.length;
        int y = n;

        for(int i=0; i<m;i++){
            nums1[y] = nums2[i];
            y++;
        }
        
        Arrays.sort(nums1);
    }
}