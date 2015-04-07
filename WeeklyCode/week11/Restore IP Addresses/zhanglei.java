public class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, "", 0);
        return result;
    }

    private void dfs(String s, String ip, int count) {
        if (count == 3 && isValid(s)) {
            result.add(ip + s);
            return;
        }
        if (s.length() < (4 - count) || s.length() > (4 - count) * 3) return;

        for (int i = 1; i < 4 && i < s.length(); i++) {
            String str = s.substring(0, i);
            if (isValid(str)) dfs(s.substring(i), ip + str + '.', count + 1);
        }
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') return s.equals("0");
        int value = Integer.parseInt(s);
        return value > 0 && value <= 255;
    }
}