public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1) {
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            fill(board, 0, i);
            fill(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            fill(board, i, 0);
            fill(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void fill(char [][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        LinkedList <Integer> queue = new LinkedList <Integer>();
        int row, col, pos = i * board[0].length + j;
        queue.offer(pos);
        while (!queue.isEmpty()) {
            pos = queue.poll();
            row = pos / board[0].length;
            col = pos % board[0].length;
            if (row > 0 && board[row - 1][col] == 'O') {
                queue.offer((row - 1) * board[0].length + col);
                board[row - 1][col] = '#';
            }
            if (row < board.length - 1 && board[row + 1][col] == 'O') {
                queue.offer((row + 1) * board[0].length + col);
                board[row + 1][col] = '#';
            }
            if(col > 0 && board[row][col - 1] == 'O') {  
                queue.offer(row*board[0].length + col - 1);  
                board[row][col - 1] = '#';  
            }  
            if(col < board[0].length - 1 && board[row][col+1] == 'O') {  
                queue.offer(row*board[0].length + col + 1);  
                board[row][col + 1] = '#';  
            }       
        }
    }
}
