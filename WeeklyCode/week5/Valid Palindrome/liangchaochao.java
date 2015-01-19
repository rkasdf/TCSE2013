public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null) return false;
        char[] charsArr=s.trim().toLowerCase().toCharArray();
        int head=0,tail=charsArr.length-1;
        while(head<tail){
            if(charsArr[head]!=charsArr[tail]){
                if(isLegal(charsArr[head])&&isLegal(charsArr[tail])){
                    return false;
                }
                if(!isLegal(charsArr[head])){
                    head++;
                }
                if(!isLegal(charsArr[tail])){
                    tail--;
                }
            }
            else{
                head++;
                tail--;
            }
        }
        return true;
    }
   public boolean isLegal(char c){
       if(c>='0'&&c<='9')
         return true;
       else if(c>='a'&&c<='z')
         return true;
       else return false;
   }
}
