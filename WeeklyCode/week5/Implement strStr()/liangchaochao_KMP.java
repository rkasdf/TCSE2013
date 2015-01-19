public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null) return -1;
        if(needle==null) return -1;
        if(needle.equals(""))return 0;
        if(haystack.equals("")) return -1;
        
        int i = 0;  
        int j = 0;
        char[] s=haystack.toCharArray();
        char[] p=needle.toCharArray();
        int sLen = s.length;  
        int pLen = p.length;
        int[] next=getNextArray(p);
        while (i < sLen && j < pLen)  {  
            if (j == -1 || s[i] == p[j])  {  
                i++;  
                j++;  
            }else{
                j = next[j];  
            }  
        }  
        if (j == pLen)  
            return i - j;  
        else  
            return -1;
    }
    public int[] getNextArray(char[] p){
        int[] next=new int[p.length];
        int k=-1;
        next[0]=-1;
        int j=0;
        while(j<p.length-1){
            if (k == -1 || p[j] == p[k]){  
                ++k;  
                ++j;  
                next[j] = k;  
            }  
            else{  
                k = next[k];
            }   
        }
        return next;
    }
}
