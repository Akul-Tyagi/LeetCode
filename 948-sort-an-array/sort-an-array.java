class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums,0,n-1);
        return nums;
    }

    private void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr,l,mid,r);
        }
        
    }

    private void merge(int[] arr, int l, int mid, int r){
        int left = mid - l + 1;
        int right = r-mid;

        int[] leftArr = new int[left];
        int[] rightArr = new int[right];

        for(int i=0; i<left;i++){
            leftArr[i] = arr[l+i];
        }

        for(int i=0; i<right;i++){
            rightArr[i] = arr[mid+1+i];
        }

        int i=0;
        int j=0;
        int k=l;

        while(i<left&&j<right){
            if(leftArr[i]<= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            } else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i<left){
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while(i<right){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}