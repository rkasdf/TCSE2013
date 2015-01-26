public class Solution {
    public String simplifyPath(String path) {
        String[] args = path.split("/+");
        int current = 1;

        for (int i = 1; i < args.length; i++) {
            String arg = args[i];
            if (arg.equals("."))
                continue;
            if (arg.equals(".."))
                current = current > 1 ? current - 1 : 1;
            else
                args[current++] = arg;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < current; i++) {
            sb.append("/");
            sb.append(args[i]);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}