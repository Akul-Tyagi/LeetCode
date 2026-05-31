class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: prerequisites ){
            int prereq = edge[1];
            int course = edge[0];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int idx=0;

        while(!q.isEmpty()){
            int curr = q.poll();
            order[idx++] = curr;

            for(int neighbours : graph.get(curr)){
                indegree[neighbours]--;
                if(indegree[neighbours]==0){
                    q.offer(neighbours);
                }
            }
        }

        return idx == numCourses? order : new int[0];
    }
}