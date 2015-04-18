public class Solution {
    public int numDistinct(String S, String T) {
		int[] opt = new int[T.length() + 1];
		opt[0] = 1;
		for(int i = 0; i < S.length(); i++) {
			for(int j = T.length() - 1; j >= 0; j--) {
				opt[j + 1] += (S.charAt(i) == T.charAt(j) ? opt[j]: 0);
			}
		}
		return opt[T.length()];
    }
}
