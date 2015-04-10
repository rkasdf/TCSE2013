public class Solution {
    boolean[] colPos,lCross,rCross;
    public int totalNQueens(int n) {
        if(n==1) return 1;
        colPos = new boolean[n];
        lCross = new boolean[2*n-1];
        rCross = new boolean[2*n-1];
        int result = 0;
        //first row
        int col = 0;
        for(;col<n/2;col++){
            setFlag(true,col,col,col+n-1);
            //rest
            result += restNQueens(n,1);
            setFlag(false,col,col,col+n-1);
        }
        result*=2;
        if(n%2==1){
            col = n/2;
            setFlag(true,col,col,col+n-1);
            result += restNQueens(n,1);
        }
        return result;
    }
    private int restNQueens(int n, int row){
        int result = 0;
        for(int col = 0;col<n;col++){
            int lCnt = col+row,rCnt = col-row+n-1;
            if(colPos[col]==false && lCross[lCnt]==false && rCross[rCnt]==false){
                if(row==n-1){
                    //the last row;
                    result++;
                }else{
                    setFlag(true,col,lCnt,rCnt);
                    result += restNQueens(n,row+1);
                    setFlag(false,col,lCnt,rCnt);
                }
            }
        }
        return result;
    }
    private void setFlag(boolean flag,int col, int lCnt, int rCnt){
        colPos[col] = flag;
        lCross[lCnt] = flag;
        rCross[rCnt] = flag;
    }
}