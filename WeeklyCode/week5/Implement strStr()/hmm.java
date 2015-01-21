public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int max = haystack.length() - needle.length()+1;
        for(int i=0;i<max;i++){
            //find first
            while(haystack.charAt(i)!=needle.charAt(0) && ++i<max);
            if(i<max){
                //fist char found
                int k=1;
                for(int j=i+1;k<needle.length() && haystack.charAt(j) == needle.charAt(k); j++,k++);
                if(k==needle.length()) return i;
            }
        }
        return -1;
    }
}