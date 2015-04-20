public class Solution {
    public int numDistinct(String S, String T) {
        int[] numForPreChar =  new int[T.length()+1];
        numForPreChar[0] = 1;
        for(int j=0;j<S.length();j++){
            char c = S.charAt(j);
            for(int i=T.length()-1;i>=0;i--){
                if(c == T.charAt(i)){
                    numForPreChar[i+1] += numForPreChar[i];
                }
            }
        }
        return numForPreChar[T.length()];
    }
}