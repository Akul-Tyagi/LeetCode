class Solution {
    public List<Boolean> checkIfPrerequisite(int num, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[num];

        for(int i=0; i<num; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            int prereq = edge[0];
            int course = edge[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        

        for(int i=0; i<num; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        boolean[][] isprereq = new boolean[num][num];

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neighbour: graph.get(curr)){
                isprereq[curr][neighbour] = true;
                for(int i=0; i<num; i++){
                    if(isprereq[i][curr] ==true){
                        isprereq[i][neighbour] = true;
                    }
                }
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.offer(neighbour);
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] query: queries){
            int u = query[0];
            int v = query[1];

            ans.add(isprereq[u][v]);
        }

        return ans;
    }
}