public class Solution {
    //正负号，空格，多余字符，越界
    public int atoi(String str) {
            str=str.trim();
            double result = 0;
            int i = 0;
            boolean flag = false;
            if(str.equals(""))
                return 0;
            if(str.charAt(0) == '-'){
                flag = true;
                i++;
            }
            if(str.charAt(0) == '+')
                i++;
            for(; i < str.length(); i++){
                if(str.charAt(i) > '9' || str.charAt(i) < '0')
                    break;
                int a = (int)(str.charAt(i) - '0');
                result = result*10 + a;
            }
            if(flag)
                return (int)(0-result);
            else
                return (int)result;
    }
}