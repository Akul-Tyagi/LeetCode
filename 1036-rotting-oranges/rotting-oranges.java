class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int freshCount= 0;

        Queue<int []> q = new LinkedList<>();

        for(int i=0; i<r; i++){
            for(int j=0; j<c;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                } else if(grid[i][j] == 1){
                    freshCount ++;
                }
            }
        }
        if(freshCount == 0){
            return 0;
        }
        int count = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()) {
            ++count;
            int size = q.size();
            for(int i = 0 ; i < size ; i++) {
                int[] point = q.poll();
                for(int dir[] : dirs) {
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];
                    if(x < 0 || y < 0 || x >= r || y >= c || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    grid[x][y] = 2;
                    q.offer(new int[]{x , y});
                    freshCount--;
                }
            }
        }
        return freshCount == 0 ? count-1 : -1;
    }
}