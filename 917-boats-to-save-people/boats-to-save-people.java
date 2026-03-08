class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int lp=0;
        int rp =n-1;
        int boats=0;

        while(lp<=rp){
            if(people[lp]+people[rp]<=limit){
                lp++;
                rp--;
                boats++;
            } else{
                rp--;
                boats++;
            }
        }
        return boats;
    }
}