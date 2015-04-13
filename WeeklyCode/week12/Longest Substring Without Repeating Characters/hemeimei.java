public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        int length = 0;
        int start=0, end=0, tempL;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int firstC = s.indexOf(c,start);
            if(firstC != i){
                tempL = end-start+1;
                if(tempL > length){
                    length = tempL;
                }
                start = firstC+1;
            }
            end = i;
        }
        tempL = end-start+1;
        return tempL>length?tempL:length;
    }
}