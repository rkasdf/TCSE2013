package iscas.leetcode.hty.validshudu;

import java.util.Arrays;

/**
 * Created by hty on 2014/12/26.
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        boolean row[] = new boolean[9];
        boolean col[] = new boolean[9];
        boolean box[] = new boolean[9];

        for (int i = 0; i < 9; i++) {
            Arrays.fill(row, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '1'])
                        return false;
                    else
                        row[board[i][j] - '1'] = true;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            Arrays.fill(col, false);
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (col[board[i][j] - '1'])
                        return false;
                    else
                        col[board[i][j] - '1'] = true;
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(box, false);
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i + k][j + l] != '.') {
                            if (box[board[i + k][j + l] - '1'])
                                return false;
                            else
                                box[board[i + k][j + l] - '1'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
