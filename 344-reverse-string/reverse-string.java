class Solution {
    private void swap(char[] s , int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public void reverseString(char[] s) {
        if(s==null){
            return;
        }

        int n = s.length;
        int l = 0;
        int r = n-1;

        if(n==1){
            return;
        }

        while(l<r){
            swap(s, l,r);
            l++;
            r--;
        }
    }
}