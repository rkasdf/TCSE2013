public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, new LinkedList<>(), num, 0);
        return res;
    }

    private void permute(List<List<Integer>> res, List<Integer> item, int[] num, int begin) {
    	if(item.size() == num.length) {
    		res.add(new ArrayList<>(item));
    		return;
    	}
    	for(int i = begin; i < num.length; i++) {
    		swap(num, begin, i);
    		item.add(num[begin]);
    		permute(res, item, num, begin + 1);
    		item.remove(item.size() - 1);
    		swap(num, begin, i);
    	}
    }

    private void swap(int[] num, int left, int right) {
    	int tmp = num[left];
    	num[left] = num[right];
    	num[right] = tmp;
    }
}

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(num);
		permuteUnique(res, new LinkedList<>(), num, new boolean[num.length]);
		return res;
	}

	private void permuteUnique(List<List<Integer>> res, List<Integer> item,
			int[] num, boolean[] visited) {
		if (item.size() == num.length) {
			res.add(new ArrayList<>(item));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if(i != 0 && !visited[i - 1] && num[i] == num[i - 1]) continue;
			if(!visited[i]) {
				visited[i] = true;
				item.add(num[i]);
				permuteUnique(res, item, num, visited);
				item.remove(item.size() - 1);
				visited[i] = false;
			}
		}
	}
}
