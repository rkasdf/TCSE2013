public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, start = 0;
        Map<Character, Integer> indexs = new HashMap<>();
        char[] arrayOfS = s.toCharArray();
        for(int i = 0; i < arrayOfS.length; i++){
            char cur = arrayOfS[i];
            if(indexs.containsKey(cur) && indexs.get(cur) >= start){
                max = Math.max(i - start, max);
                start = indexs.get(cur) + 1;
            }
            indexs.put(cur, i);
        }
        max = Math.max(max,s.length() - start);
        return max;
    }
}
