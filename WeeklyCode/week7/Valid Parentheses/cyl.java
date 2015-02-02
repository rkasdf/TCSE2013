public class Solution {
    public boolean isValid(String s) {
        int length = s.length(),top = -1;
        char[] stack = new char[length];
        for(int i=0;i<length;i++){
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{')
                stack[++top] = c;
            else{
                if(top<0)
                    return false;
                if(c==')'&&stack[top]!='('||c==']'&&stack[top]!='['||c=='}'&&stack[top]!='{')
                    return false;
                top--;
            }
        }
        if(top>=0)
            return false;
        return true;
    }
}
