class Solution {
    public String mergeAlternately(String word1, String word2) {
        if(word1 == null){
            return word2;
        }
        if(word2 == null){
            return word1;
        }

        int n = word1.length();
        int m = word2.length();
        StringBuilder merged = new StringBuilder();

        int p1=0;
        int p2=0;

        while(p1<n || p2<m){
            if(p1<n){
                merged.append(word1.charAt(p1));
                p1++;
            }
            if(p2<m){
                merged.append(word2.charAt(p2));
                p2++;
            }
        }
        return merged.toString();
    }
}