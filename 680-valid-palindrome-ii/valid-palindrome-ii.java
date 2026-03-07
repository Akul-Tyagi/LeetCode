class Solution {

    private boolean isPalindrome(String s, int l, int r){
        if(s.isEmpty()){
            return true;
        }
        while(l<=r){
            char currLeft = s.charAt(l);
            char currRight =s.charAt(r);

            if(currLeft!= currRight){
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        int n = s.length();
        int l = 0;
        int r = n-1;

        while(l<=r){
            char currLeft = s.charAt(l);
            char currRight =s.charAt(r);

            if(currLeft != currRight){
                if(isPalindrome(s,l+1,r) || isPalindrome(s,l,r-1)){
                    return true;
                } else {
                    return false;
                }
            }else{
                l++;
                r--;
            }
        }
        return true;
        
    }
}