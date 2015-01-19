class Solution {
public:
    int strStr(char *haystack, char *needle) {
        int i,j,p,len1,len2;
        i=j=p=len1=len2=0;
        while(haystack[i]!='\0'){
            len1++;
            i++;
        }
        while(needle[j]!='\0'){
            len2++;
            j++;
        }
        i=j=0;
        while(haystack[p]!='\0'&&len1-p>=len2){
            if(haystack[p]==needle[0]){
                i=p+1;
                j=1;
                while(haystack[i]==needle[j]&&needle[j]!='\0'){
                    i++;
                    j++;
                }
                if(needle[j]=='\0'){
                    return p;
                }
            }
            p++;
        }
        if(needle[0]=='\0'){
            return 0;
        }else{
            return -1;
        }
      
        
    }
};