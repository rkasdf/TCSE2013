public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null)
            return 0;
        if (word1 == null)
            return word2.length();
        if(word2 == null)
            return word1.length();
        int m = word1.length() + 1;
        int n = word2.length() + 1;
        int [][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            distance[i][0] = i;
        }
        for (int j = 1; j < n; j++) {
            distance[0][j] = j;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                distance[i][j] = min(
                    distance[i][j - 1] + 1,
                    distance[i - 1][j] + 1,
                    distance[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
            }
        }
        return distance[m-1][n-1];
    }
    
    public int min(int x, int y, int z) {
        return (x = x < y ? x : y) < z ? x : z;
    }
}
