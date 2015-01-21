public class Solution {
    public int atoi(String str) {
        if(str == null) return 0;
        int result = 0;
        boolean isMinus = false, needNum = false;
        int minLimit = Integer.MIN_VALUE/10;
        for(int i=0;i<str.length();i++){
            int aChar = str.charAt(i);
            if(aChar >= '0' && aChar <= '9'){
                aChar -= '0';
                if(result < minLimit+aChar/9){
                   result = Integer.MIN_VALUE;
                   break;
                } 
                result = result*10-aChar;
                needNum = true;
            }else{
                if(needNum) break;
                if(aChar == ' ') continue;
                if(aChar == '+'){
                    needNum = true;
                }else if(aChar == '-'){
                    needNum = true;
                    isMinus = true;
                }else{
                    break;
                }
            }
        }
        if(!isMinus){
            if(result == Integer.MIN_VALUE) result = Integer.MAX_VALUE;
            else result = -result;
        }
        return result;
    }
}