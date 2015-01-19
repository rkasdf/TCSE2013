public class Solution {
    public int atoi(String str) {
        if(str==null||str.equals(""))
            return 0;
        str=str.trim();
        char[] chars=str.toCharArray();
        if(chars.length==0) return 0;
        double sum=0;
        int flag=1;
        int index=0;
        if(chars[0]=='-'||chars[0]=='+'){
            flag=chars[0]=='-'?-1:1;
            index=1;
        }
        for(int i=index;i<chars.length;i++){
            if(chars[i]>'9'||chars[i]<'0')
                break;
            int charToInt=chars[i]-'0';
            sum=sum*10+charToInt;
        }
        sum=flag*sum;
        if(sum>=Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(sum<=Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else return (int)sum;
    }
}
