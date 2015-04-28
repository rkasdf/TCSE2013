public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        if(matrix == null || matrix.length == 0) return answer;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for (int x = 0, y = 0, xDir = 1, yDir = 0,num = 0; num < m * n; num++) {
            answer.add(matrix[y][x]);
            hasVisited[y][x] = true;
            if (x + xDir < 0 || y + yDir < 0 || x + xDir == n || y + yDir == m || hasVisited[y + yDir][x + xDir]) {
                if (xDir != 0) {
                    yDir = xDir;
                    xDir = 0;
                } else {
                    xDir = -yDir;
                    yDir = 0;
                }
            }
            x += xDir;
            y += yDir;
        }
        return answer;
    }
}
