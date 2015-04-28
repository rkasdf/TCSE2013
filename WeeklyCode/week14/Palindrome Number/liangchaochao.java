public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int n = 0;
        int b = x;
        while(x != 0){
            n *= 10;
            n += x % 10;
            x = x / 10;
        }
        return b == n;
    }
}
