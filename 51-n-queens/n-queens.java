class Solution {

    public boolean isSafe(int n, char[][] board, int row, int col){
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        for(int i=row-1, j=col+1; i>=0 && j<n; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public void nQueens(int n, List<List<String>> output, char[][] board, int row){
        if(row == n){
            List<String> solution = new ArrayList<>();
            for(char[] rowArray: board){
                solution.add(new String(rowArray));
            }
            output.add(solution);
            return;
        }

        for(int col = 0; col<n; col++){
            if(isSafe(n, board, row, col)){
                board[row][col] = 'Q';
                nQueens(n, output, board, row+1);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0; i<n;i++){
            Arrays.fill(board[i], '.');
        }

        nQueens(n,result,board,0);
        return result;
    }
}