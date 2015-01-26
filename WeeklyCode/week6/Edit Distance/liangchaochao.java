public class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length()+1;
        int n=word2.length()+1;
        int[][] minDistances=new int[m][n];
        for(int i=0;i<m;i++)
            minDistances[i][0]=i;
        for(int j=0;j<n;j++)
            minDistances[0][j]=j;
        for(int row=1;row<m;row++){
            for(int column=1;column<n;column++){
                int left=minDistances[row-1][column]+1;
                int up=minDistances[row][column-1]+1;
                int min=minDistances[row-1][column-1]+(word1.charAt(row-1)==word2.charAt(column-1)?0:1);
                min=min<left?min:left;
                min=min<up?min:up;
                minDistances[row][column]=min;
            }
        }
        return minDistances[m-1][n-1];
    }
}
