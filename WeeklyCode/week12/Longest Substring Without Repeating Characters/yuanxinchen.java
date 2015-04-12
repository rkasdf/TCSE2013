public class solution {
  public int lengthOfLongestSubstring(String s) {
    int res = 0;
    Map<Character, Integer> map = new HashMap<>();
    for(int left = 0, right = 0; right < s.length(); right++) {
        Character curt = s.charAt(right);
        if(map.containsKey(curt)) {
          left = Math.max(left, map.get(curt) + 1);
        }
      map.put(curt, right);
        res = Math.max(res, right - left + 1);
    }
    return res;
  }
}
