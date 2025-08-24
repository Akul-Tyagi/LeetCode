class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int d = nums1.length + nums2.length ;
        int[] m = new int[d];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                m[k++] = nums1[i++];
            } else {
                m[k++] = nums2[j++];
            }
        }
            while (i < nums1.length) m[k++] = nums1[i++];
            while (j < nums2.length) m[k++] = nums2[j++];

            if(d%2==1){
                return m[d/2];
            }else{
                return (m[d/2-1]+ m[d/2])/2.0;
            }
        }
    }