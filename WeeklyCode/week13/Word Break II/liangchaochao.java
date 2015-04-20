public class Solution {
    private Map<String, List<String>> persist;
    public List<String> wordBreak(String s, Set<String> wordDict) {
        persist = new HashMap<>();
        return wordBreakRe(s, wordDict);
    }
    
    private List<String> wordBreakRe(String s, Set<String> wordDict){
        List<String> result = new ArrayList<>();
        if(s == null || s.equals("") ) return result;
        if(persist.containsKey(s)){
            return persist.get(s);
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            builder.append(cur);
            if(wordDict.contains(builder.toString())){
                if(i < s.length() - 1){
                    List<String> next = wordBreakRe(s.substring(i + 1), wordDict);
                    for(String sentence : next){
                        result.add(builder.toString() + " " + sentence);
                    }
                }else{
                    result.add(builder.toString());
                }
            }
        }
        persist.put(s, result);
        return result;
    }
}
