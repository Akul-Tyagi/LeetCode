class Solution {
    public List<List<String>> partition(String s) {
        if(s==null || s.length()==0) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        backtrack(s, res, new ArrayList<>());
        return res;
    }
    public void backtrack(String s, List<List<String>> res, ArrayList<String> temp){
        if(s==null || s.length() == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=1; i<=s.length(); i++){
            String cache = s.substring(0,i);
            if(!isPalindrome(cache)){
                continue;
            } 

            temp.add(cache);
            backtrack(s.substring(i, s.length()),res, temp);
            temp.remove(temp.size()-1);
        }
        return;
    }
    public boolean isPalindrome(String s){
        int l=0;
        int r= s.length()-1;
        while(l<=r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}