public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		int s1Len = s1 != null ? s1.length() : 0;
		int s2Len = s2 != null ? s2.length() : 0;
		int s3Len = s3 != null ? s3.length() : 0;
		if (s3Len != s1Len + s2Len)
			return false;
		if(s1Len == 0 && s2 != null) {
			return s2.equals(s3);
		}
		if(s2Len == 0 && s1 != null) {
			return s1.equals(s3);
		}
		boolean[][] opt = new boolean[s1Len + 1][s2Len + 1];
		for(int i = 0; i < s1Len; i++) {
			opt[i + 1][0] = s1.charAt(i) == s3.charAt(i);
		}
		for(int i = 0; i < s2Len; i++) {
			opt[0][i + 1] = s2.charAt(i) == s3.charAt(i);
		}
		for(int i1 = 1; i1 <= s1Len; i1++) {
			for(int i2 = 1; i2 <= s2Len; i2++) {
				opt[i1][i2] = opt[i1 -1][i2] && s1.charAt(i1 - 1) == s3.charAt(i1 + i2 - 1)
						|| opt[i1][i2 - 1] && s2.charAt(i2 - 1) == s3.charAt(i1 + i2 - 1);
			}
		}
		return opt[s1Len][s2Len];
	}
}
