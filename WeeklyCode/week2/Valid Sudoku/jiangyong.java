public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length != 9) return false;
        HashSet<Integer> row = new HashSet<Integer>();
        HashSet<Integer> col = new HashSet<Integer>();
        HashSet<Integer> block = new HashSet<Integer>();
        for(int i=0; i<9; i++){
            if(board[i].length != 9) return false;
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue;
                if(!row.add(board[i][j]-'0'))
                    return false;
            }
            row.clear();
        }
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[j][i] == '.') continue;
                if(!col.add(board[j][i]-'0'))
                    return false;
            }
            col.clear();
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    for(int l=0; l<3; l++){
                        if(board[3*i+k][3*j+l] == '.') continue;
                        if(!block.add(board[3*i+k][3*j+l]-'0'))
                            return false;
                    }
                }
                block.clear();
            }
        }
        return true;
    }
}
