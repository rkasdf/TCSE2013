package iscas.leetcode.hty.simplifypath;

import java.util.*;

/**
 * Created by hty on 2015/1/25.
 */
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] paths = path.split("/");
        for(String str : paths) {
            if (str.equals("") || str.equals(".") || (str.equals("..") && stack.empty())) {
                continue;
            } else if (str.equals("..") && !stack.empty()) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }
        Stack<String> temstack = new Stack<String>();
        while (!stack.empty()) {
            temstack.push(stack.pop());
        }
        path = "";
        while (!temstack.empty()) {
            path += "/" + temstack.pop();
        }
        return path.equals("") ? "/" : path;
    }

    public String simplifyPath2(String path) {
        List<String> list = new LinkedList<String>();
        String[] paths = path.split("/");
        for (String str : paths) {
            if (str.equals("") || str.equals(".") || (str.equals("..") && list.isEmpty())) {
                continue;
            } else if (str.equals("..") && !list.isEmpty()) {
                list.remove(list.size() - 1);
            } else {
                list.add(str);
            }
        }
        path = "";
        for (int i = 0; i < list.size() ; i++) {
            path += "/" + list.get(i);
        }
        return path.equals("") ? "/" : path;
    }

}
