class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int left = 0;
        int right =0;

        for(int i=0; i<n;i++){
            left = Math.max(left, weights[i]);
            right += weights[i];
        }

        while(left<right){
            int mid = left +(right -left)/2;
            int need = 1;
            int curr = 0;

            for(int i = 0; i<n;i++){
                if(curr+weights[i]>mid){
                    need+=1;
                    curr=0;
                }
                curr += weights[i];
            }
            if(need>days){
                left = mid +1;
            } else{
                right = mid;
            }
        }
        return left;
    }
}