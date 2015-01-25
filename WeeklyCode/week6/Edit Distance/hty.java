package iscas.leetcode.hty.editdistance;

/**
 * Created by hty on 2015/1/25.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        int row = word1.length() + 1;
        int col = word2.length() + 1;
        int[][] note = new int[row ][col];
        for (int i = 0; i < row; i++) {
            note[i][0] = i;
        }
        for (int i = 0; i < col; i++) {
            note[0][i] = i;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (word1.charAt(i -1) == word2.charAt(j -1)) {
                    note[i][j] = note[i - 1][j - 1];
                } else {
                    note[i][j] = note[i - 1][j - 1] + 1;
                }
                note[i][j] = Math.min(note[i][j], Math.min(note[i - 1][j] + 1, note[i][j - 1] + 1));
            }
        }
        return note[row - 1][col - 1];
    }
}
