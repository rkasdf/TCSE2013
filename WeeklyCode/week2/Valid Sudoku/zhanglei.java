public class Solution {
    private Set<Integer> values = new HashSet<Integer>();

    public boolean isValidSudoku(char[][] board) {

        if (board.length != 9 || board[0].length != 9) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (!valid(i, null, board))
                return false;
        }

        for (int j = 0; j < 9; j++) {
            if (!valid(null, j, board))
                return false;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!valid(i, j, board))
                    return false;
            }
        }

        return true;
    }

    private boolean valid(Integer row, Integer col, char[][] board) {
        values.clear();
        if (row == null) {
            for (int i = 0; i < 9; i++) {
                if (Character.isDigit(board[i][col])) {
                    int value = Character.getNumericValue(board[i][col]);
                    if (values.contains(value))
                        return false;
                    else
                        values.add(value);
                }
            }
        } else if (col == null) {
            for (int i = 0; i < 9; i++) {
                if (Character.isDigit(board[row][i])) {
                    int value = Character.getNumericValue(board[row][i]);
                    if (values.contains(value))
                        return false;
                    else
                        values.add(value);
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Character.isDigit(board[i + 3 * row][j + 3 * col])) {
                        int value = Character
                                .getNumericValue(board[i + 3 * row][j + 3 * col]);
                        if (values.contains(value))
                            return false;
                        else
                            values.add(value);
                    }
                }
            }
        }

        return true;
    }
}