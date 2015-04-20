public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.equals("") || !canWordBreak(s, wordDict)) return new ArrayList<>();
        //存储从s中取出前i个字符是否可以wordBreak
        Map<Integer,List<String>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>());
        //遍历，每次取出一个字符
        for(int i = 0; i < s.length(); i++){
            StringBuilder builder = new StringBuilder(s.substring(0, i + 1));
            for(int j = 0; j <= i; j++){
                if(dp.get(j) != null && wordDict.contains(builder.toString())){
                    List<String> next = dp.get(j);
                    List<String> result = dp.get(i + 1);
                    if(result == null){
                        result = new ArrayList<>();
                        dp.put(i + 1, result);
                    }
                    if(next.isEmpty()){
                        result.add(builder.toString());
                    }else{
                        for(String sentence: next){
                            result.add(sentence + " " + builder.toString());
                        }
                    }
                }
                builder.deleteCharAt(0);
            }
        }
        List<String> answer = dp.get(s.length());
        answer = answer != null ? answer : new ArrayList<>();
        return answer;
    }
    
    public boolean canWordBreak(String s, Set<String> wordDict) {
        if(s == null || s.equals("")) return true;
        //存储从s中取出前i个字符是否可以wordBreak
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //遍历，每次取出一个字符
        for(int i = 0; i < s.length(); i++){
            StringBuilder builder = new StringBuilder(s.substring(0, i + 1));
            for(int j = 0; j <= i; j++){
                if(dp[j] && wordDict.contains(builder.toString())){
                    dp[i + 1] = true;
                    break;
                }
                builder.deleteCharAt(0);
            }
        }
        return dp[s.length()];
    }
}
