public class Solution {
    public double pow(double x, int n) {
        if(n==0 || x==1 || (x == -1 && n%2==0)) return 1;
        if(n==1 || (x==-1 && n%2==1)) return x;
        if(n<0){
            x = 1/x;
            n=-n;
        } 
        return n%2 == 0 ? pow(x*x,n/2):pow(x*x,n/2)*x;
    }
}