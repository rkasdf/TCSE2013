public class Solution {
    public int strStr(String haystack, String needle) {

        int len1 = needle.length();
        int len2 = haystack.length();
        if(len1==0){
            return 0;
        }
        
        char c = needle.charAt(0);
        int i=0;
        while(i<len2){
            if(haystack.charAt(i)==c){
                if(i+len1-1>=len2){
                    return -1;
                }
                if(haystack.substring(i,i+len1).equals(needle)){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}