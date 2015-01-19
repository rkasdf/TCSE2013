class Solution {
public:
    int strStr(char *haystack, char *needle) {
        if(!*needle)return 0;   	//"",""->true
        if(!*haystack)return -1;
        int len_needle = strlen(needle);
        int index = 0;
        int end = len_needle-1;		//time limit
        while(haystack[end]!='\0'){
            int i = index;
            int j = 0;
            while(haystack[i]!='\0' && needle[j]!='\0' && haystack[i] == needle[j]){
                i++;
                j++;
            }
            if(j==len_needle)return index;
            index++;
            end++;
        }
        return -1;
    }
};