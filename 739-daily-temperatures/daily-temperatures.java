class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i =0; i<n; i++){
            while(!s.isEmpty() && temp[i]>temp[s.peek()]){
                int x = s.pop();
                res[x] = i- x;
            }
            s.push(i);
        }
        return res;
    }
}