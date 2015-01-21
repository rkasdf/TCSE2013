public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return true;
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            int aChar,bChar;
            for(;(aChar = isAlphanumeric(s.charAt(i)))==-1 && i<j;i++);
            for(;(bChar = isAlphanumeric(s.charAt(j)))==-1 && i<j;j--);
            if(bChar!=aChar) return false;
        }
        return true;
    }
    private int isAlphanumeric(char x){
        if((x>='0' && x <= '9') || (x>='A' && x <= 'Z')) return x;
        if (x>='a' && x <= 'z') return x-32;
        return -1;
    }
}