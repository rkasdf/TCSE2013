public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        int rowL = 0, colL = 0, rowR = matrix.length - 1, colR = matrix[0].length - 1;

        while (rowL <= rowR && colL <= colR) {
            for (int i = colL; i <= colR; i++) result.add(matrix[rowL][i]);
            for (int i = rowL + 1; i <= rowR; i++) result.add(matrix[i][colR]);
            for (int i = colR - 1; i >= colL && rowL != rowR; i--) result.add(matrix[rowR][i]);
            for (int i = rowR - 1; i > rowL && colL != colR; i--) result.add(matrix[i][colL]);
            rowL++; colL++; rowR--; colR--;
        }

        return result;
    }
}