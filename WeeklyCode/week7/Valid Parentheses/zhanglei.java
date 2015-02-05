public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || !isMatch(stack.pop(), c))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isMatch(char i, char j) {
        return i == '(' && j == ')' || i == '[' && j == ']' || i == '{' && j == '}';
    }
}