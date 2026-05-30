class Solution {
    public boolean canFinish(int num, int[][] prerequisites) {
        ArrayList<Integer>[] al = new ArrayList[num];
        int[] degree = new int[num];
        ArrayList<Integer> bfs = new ArrayList();
        for(int i =0; i<num; i++){
            al[i]= new ArrayList<Integer>();
        }

        for(int[] e: prerequisites){
            al[e[1]].add(e[0]);
            degree[e[0]]++;
        }

        for(int i=0; i<num; i++){
            if(degree[i] == 0){
                bfs.add(i);
            }
        }

        for(int i=0; i<bfs.size(); i++){
            for(int j: al[bfs.get(i)]){
                if(--degree[j] == 0){
                    bfs.add(j);
                }
            }
        }
        return bfs.size() == num;
    }
}