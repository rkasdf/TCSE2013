public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer> nodeSet = new HashSet<Integer>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                char num = board[i][j];
                if(num == '.') continue;
                int num10 = num*10;
                int col = num10+j;
                int row = 100+num10+i;
                int part = 200+num10+j/3+(i/3)*3;
                if(!nodeSet.add(col) || !nodeSet.add(row) || !nodeSet.add(part)){
                    return false;
                }
            }
        }
        return true;
    }
}