public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null) return -1;
        if(needle==null) return -1;
        if(needle.equals(""))return 0;
        if(haystack.equals("")) return -1;
        char[] sourceChars=haystack.toCharArray();
        char[] regexChars=needle.toCharArray();
        int index=0,offset=0;
        while(index<sourceChars.length){
            if(sourceChars[index]==regexChars[offset]){
                offset++;
                if(offset==regexChars.length){
                    return index-offset+1;
                }
            }else{
                index=index-offset;
                offset=0;
            }
            index++;
        }
        return -1;
    }
}
