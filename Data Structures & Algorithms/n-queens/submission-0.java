class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> list = new ArrayList<>();
        for(char[] c : board){
            Arrays.fill(c,'.');
        }

        backtrack(board,0,list,n);
        return list;
    }

    void backtrack(char[][] board, int row, List<List<String>> res,int n ){

        if(row == board.length){
            res.add(construct(board));
            return;
        }

        for(int i = 0 ; i < board.length ; i++){

            if(isSafe(board,row,i,n)){
                board[row][i] = 'Q';
                backtrack(board,row+1,res,n);
                board[row][i] = '.';
            }
        }
    }
    boolean isSafe(char[][] board,int row,int col,int n){
        for(int i = 0 ; i < row ; i++){
            if(board[i][col] == 'Q') return false;
        }

        for(int i = row-1,j = col-1 ; i>= 0 && j >=0;i--,j--){
            if(board[i][j] == 'Q') return false;
        }

        for(int i = row-1,j=col+1; i >= 0 && j < n ; i--,j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }

    List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();

        for(char[] row : board){
            list.add(new String(row));

        }

        return list;
    }
}
