public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null){
            return true;
        }
        
        s=s.toLowerCase();
        s=s.trim();
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            while(s.charAt(i)>'z'||s.charAt(i)<'0'||(s.charAt(i)>'9'&&s.charAt(i)<'a')){
                i++;
                if(i>j){
                    return true;
                }
            }
            while(s.charAt(j)>'z'||s.charAt(j)<'0'||(s.charAt(j)>'9'&&s.charAt(j)<'a')){
                j--;
                if(i>j){
                    return true;
                }
            }
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        
        return true;
    }
}