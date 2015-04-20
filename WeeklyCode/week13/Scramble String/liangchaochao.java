public class Solution {
    private Map<String, Boolean> dp;
    public boolean isScramble(String s1, String s2){
        dp = new HashMap<>();
        return isScrambleRe(s1, s2);
    }
    public boolean isScrambleRe(String s1, String s2) {
        String key = getKey(s1, s2);
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        if(s1 == s2 || s1.equals(s2)) {
            dp.put(key,true);
            return true;
        }
        if(s1 == null || s2 == null || s1.length() != s2.length() || !sameChars(s1, s2)){
            dp.put(key, false);
            return false;
        } 
        if(s1.length() == 2){
            dp.put(key, true);
            return true;
        }
        for(int i = 0; i < s1.length() - 1; i++){
                boolean result = isScrambleRe(s1.substring(0, i + 1), s2.substring(0, i + 1)) &&
                    isScrambleRe(s1.substring(i + 1), s2.substring(i + 1));
                
                result = result || (isScrambleRe(s1.substring(0, i + 1), s2.substring(s2.length() - i - 1, s2.length())) &&
                    isScrambleRe(s1.substring(i + 1, s1.length()), s2.substring(0, s2.length() - i - 1)));
                    
                if(result){
                    dp.put(key, true);
                    return true;
                }
        }
        dp.put(key,false);
        return false;
    }
    
    private String getKey(String s1, String s2){
        return s1 + "_" + s2;    
    }
    
    private boolean sameChars(String s1, String s2){
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        String tmp1= String.valueOf(s1Arr);
        String tmp2 = String.valueOf(s2Arr);
        return tmp1.equals(tmp2);
    }
}
