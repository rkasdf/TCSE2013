public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char[] arrays = s.toCharArray();
        for(char c:arrays){
            switch(c){
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ')':case '}':case ']':
                    if(stack.empty() || c != stack.pop()){
                        return false;
                    }
                    break;
            }
        }
        if(stack.empty()) return true;
        else return false;
    }
}
