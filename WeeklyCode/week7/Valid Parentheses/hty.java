package iscas.leetcode.hty.validparentheses;

import java.util.Stack;

/**
 * Created by hty on 2015/2/2.
 */
public class Solution {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            if (sc == '(' || sc == '[' || sc == '{') {
                stack.push(sc);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    Character c = stack.pop();
                    if (c == '(' && sc != ')') {
                        return false;
                    } else if (c == '[' && sc != ']') {
                        return false;
                    } else if (c == '{' && sc != '}') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
