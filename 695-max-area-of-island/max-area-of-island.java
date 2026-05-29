class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==1){
                    int count = bfs(grid, i,j);
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
    public int bfs(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0){
            return 0;
        }
        grid[i][j] = 0;
        return 1 +
        bfs(grid,i+1,j)+
        bfs(grid,i-1,j)+
        bfs(grid,i,j+1)+
        bfs(grid,i,j-1);
    }
}