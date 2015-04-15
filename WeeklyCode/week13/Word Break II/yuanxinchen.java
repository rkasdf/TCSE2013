public class solution {
  public List<String> wordBreak(String s, Set<String> dict) {
		List<String> res = new ArrayList<>();
		if(!canBreak(s, dict)) {
			return res;
		}
		int maxLength = 0;
		for(String word : dict) {
			maxLength = Math.max(maxLength, word.length());
		}
		wordBreak(s, dict, "", res, 0, maxLength);
		return res;
	}

	/***
	 * backtracking
	 */
	private void wordBreak(String s, Set<String> dict, String item,
			List<String> res, int begin, int maxLength) {
		if (begin >= s.length()) {
			res.add(item);
			return;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = begin; i < (begin + maxLength) && i < s.length(); i++) {
			builder.append(s.charAt(i));
			String curt = builder.toString();
			if(dict.contains(curt)) {
				String nextItem = item.length() > 0 ? item + " " + curt : curt;
				wordBreak(s, dict, nextItem, res, i + 1, maxLength);
			}
		}
	}

	private boolean canBreak(String s, Set<String> dict) {
		boolean[][] opt = new boolean[s.length() + 1][s.length() + 1];
		for (int i = 0; i <= s.length(); i++) {
			opt[0][i] = true;
			opt[i][0] = true;
		}
		int wordLength = 0;
		for(String word : dict) {
			wordLength = Math.max(wordLength, word.length());
		}
		for (int start = 1; start <= s.length(); start++) {
			int minEnd = Math.min(s.length(), start + wordLength - 1);
			for (int end = start; end <= minEnd; end++) {
				String word = s.substring(start - 1, end);
				opt[start][end] = opt[1][end]
						|| (opt[1][start - 1] && dict.contains(word));
				opt[1][end] = opt[start][end] || opt[1][end];
			}
		}
		return opt[1][s.length()];
	}
}
