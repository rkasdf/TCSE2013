public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows=new boolean[9][9];
        boolean[][] columns=new boolean[9][9];
        boolean[][] blocks=new boolean[9][9];
        if(board.length!=9) return false;
        for(int row=0;row<9;row++){
            if(board[row].length!=9)return false;
            for(int column=0;column<9;column++){
                char numberChar=board[row][column];
                if(numberChar=='.') continue;
                int number=numberChar-'1';
                if(rows[row][number] || columns[column][number] || blocks[row-row%3+column/3][number])
                    return false;
                else
                    rows[row][number]=columns[column][number]=blocks[row-row%3+column/3][number]=true;
            }
        }
        return true;
    }
}
