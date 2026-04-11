class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        int[][] ext = new int[n][3];
        for(int i=0; i<n;i++){
            ext[i][0] =i;
            ext[i][1] = tasks[i][0];
            ext[i][2] = tasks[i][1];
        }

        Arrays.sort(ext,(a,b) -> a[1]-b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[2]==b[2] ? a[0]-b[0] :a[2]-b[2]);
        int time =0;
        int ai = 0;
        int ti = 0;
        while(ai < n) {
            while(ti < n && ext[ti][1] <= time) {
                pq.offer(ext[ti++]);
                
            }
            if(pq.isEmpty()) {
                time = ext[ti][1];
                continue;
            }
            int[] bestFit = pq.poll();
            ans[ai++] = bestFit[0];
            time += bestFit[2];
        }
        return ans;
    }
}