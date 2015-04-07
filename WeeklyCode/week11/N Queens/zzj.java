public class Solution {
    public int result;
    public int[][] mymap;
    public int nn;
    public int[][] dir = {{-1,-1},{-1,1}};
    public int totalNQueens(int n) {
        result = 0;
        if(n==1) return 1;
        mymap = new int[n+1][n+1];
        nn = n;
        
        for(int i = 1; i <= n/2; i++){
            mymap[1][i] = 1;
            digui(2);
            mymap[1][i] = 0;
        }
        result = result*2;
        if(n%2==1) {
            mymap[1][n/2+1] = 1;
            digui(2);
            mymap[1][n/2+1] = 0;
        }
        return result;
    }
    public void digui(int n){
        if(n==nn){
            for(int i = 1; i <= nn; i++){
                if(validate(n,i)) result++;
            }
            return;
        }
        for(int i = 1; i <= nn; i++){
            if(validate(n,i)){
                mymap[n][i] = 1;
                digui(n+1);
                mymap[n][i] = 0;
            }
        }
    }
    public boolean validate (int x, int y){
        for(int i = 1; i < x; i++){
            if(mymap[i][y]==1) return false;
        }
        for(int i = 0; i < 2; i++){
            int xx = x+dir[i][0];
            int yy = y+dir[i][1];
            while(xx>=1 && yy>=1 && yy<=nn){
                if(mymap[xx][yy]==1) return false;
                xx += dir[i][0];
                yy += dir[i][1];
            }
        }
        return true;
    }
}
