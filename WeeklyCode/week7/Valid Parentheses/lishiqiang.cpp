class Solution {
public:
    bool isValid(string s) {
        stack<char> stk;
        for(char c:s){
            switch(c){
                case ')':
                     if(!stk.empty()&&stk.top()=='('){
                         stk.pop();
                         break;
                     }else{
                         return false;
                     }
                case '}':
                     if(!stk.empty()&&stk.top()=='{'){
                         stk.pop();
                         break;
                     }else{
                         return false;
                     }
                case ']':
                     if(!stk.empty()&&stk.top()=='['){
                         stk.pop();
                         break;
                     }else{
                         return false;
                     }
                default:
                     stk.push(c);
            }
        }
        return stk.empty();
    }
};