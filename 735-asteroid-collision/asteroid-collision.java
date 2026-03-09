class Solution {
    public int[] asteroidCollision(int[] as) {
        int n = as.length;
        Stack<Integer> s = new Stack<>();


        for(int i=0; i<n;i++){
            int x = as[i];
            if(x>=0){
                s.push(as[i]);
            } else{

                while(x<0){
                    if(s.isEmpty() || s.peek()<0){
                        s.push(x);
                        break;
                    } else if(s.peek()>0 && Math.abs(x)>s.peek()){
                        s.pop();
                    } else if(s.peek()>0 && Math.abs(x) == s.peek()){
                        s.pop();
                        break;
                    } else{
                        break;
                    }
                }
            }
        }
        int[] res = new int[s.size()];
        for(int i=s.size()-1; i>=0; i--){
            res[i] = s.pop();
        }
        return res;
    }
}