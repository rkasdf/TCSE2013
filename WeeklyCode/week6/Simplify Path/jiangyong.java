public class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0)
            return "/";
        String [] splits = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < splits.length; i++) {
            if (splits[i].equals("") || splits[i].equals(".")) {
                continue;
            } else if (splits[i].equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(splits[i]);
            }
        }
        if (stack.size() == 0) 
            return "/";
        String spath = "";
        for (int i = 0; i < stack.size(); i++) {
            spath = spath.concat("/".concat(stack.get(i)));
        }
        return spath;
    }
}
