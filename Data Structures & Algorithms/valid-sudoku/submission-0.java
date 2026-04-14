class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[i].length ; j++){

                char c = board[i][j];

                if(c == '.') continue;

                String rowSeen = c + " in row " + i;
                String colSeen = c + " in col " + j;
                String boxSeen = c + " in box " + (i/3)*3 + (j/3);

                if(seen.contains(rowSeen)){
                    return false;
                }else{
                    seen.add(rowSeen);
                }

                if(seen.contains(colSeen)){
                    return false;
                }else{
                    seen.add(colSeen);
                }

                if(seen.contains(boxSeen)){
                    return false;
                }else{
                    seen.add(boxSeen);
                }
            }
        }

        return true;
        
    }
}
