class Solution {
    public boolean existHelper(char[][] board,int r, int c, String word) {
       
        if(word.length()==0){
            return true;
        }
        int R = board.length, C = board[0].length;
        if(r==R || r==-1 || c==C || c==-1){
            return false;
        }
        char temp = board[r][c];
        if(temp!=word.charAt(0)){
            return false;
        }
        board[r][c] = '1';
        boolean up = existHelper(board,r-1,c,word.substring(1));
        if(up) return true;
        boolean down = existHelper(board,r+1,c,word.substring(1));
        if(down) return true;
        boolean left = existHelper(board,r,c-1,word.substring(1));
        if(left) return true;
        boolean right = existHelper(board,r,c+1,word.substring(1));
        if(right) return true;
        board[r][c] = temp;
        
        return up||down||right||left;
    }
    public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean flag = existHelper(board,i,j,word);
                    if(flag){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
}
