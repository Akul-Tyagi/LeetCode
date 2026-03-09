class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        ArrayList<Integer> scores = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(operations[i].equals("C")){
                scores.remove(scores.size()-1);
            } else if(operations[i].equals("D")){
                scores.add(scores.get(scores.size()-1)*2);
            } else if(operations[i].equals("+")){
                scores.add(scores.get(scores.size()-1) + scores.get(scores.size()-2));
            } else {
                scores.add(Integer.parseInt(operations[i]));
            }
        }
        int ans=0;

        for(int i=0; i<scores.size(); i++){
            ans = ans + scores.get(i);
        }
        return ans;
    }
}