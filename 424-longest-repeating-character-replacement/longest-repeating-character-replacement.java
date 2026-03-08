class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> frq = new HashMap<>();
        int res= 0;
        int i=0;
        int max= 0;

        for(int j=0; j<n; j++){
            char c = s.charAt(j);
            frq.put(c, frq.getOrDefault(c,0)+1);
            max = Math.max(max, frq.get(c));

            while((j-i+1)-max>k){
                char remove = s.charAt(i);
                frq.put(remove, frq.get(remove)-1);
                i++;
            }
            res = Math.max(res,j-i+1);
        }
        return res;
    }
}