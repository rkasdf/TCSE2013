public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        //initial
        for(int row = 0; row < distance.length; row++) {
            distance[row][0] = row;
        }
        for(int col = 0; col < distance[0].length; col++) {
            distance[0][col] = col;
        }
        for(int col = 1; col < word2.length() + 1; col++) {
            for(int row = 1; row < word1.length() + 1; row++) {
              int tmp = Math.min(distance[row - 1][col] + 1, distance[row][col - 1] + 1);
              if(word1.charAt(row - 1) == word2.charAt(col - 1)) {
                distance[row][col] = Math.min(distance[row - 1][col - 1], tmp);
              } else {
                distance[row][col] = Math.min(distance[row - 1][col - 1] + 1, tmp);
              }
            }
        }
        return distance[word1.length()][word2.length()];
    }
}
