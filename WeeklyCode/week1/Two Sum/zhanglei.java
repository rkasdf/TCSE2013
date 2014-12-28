public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> index = new HashMap<Integer, Integer>();
		int[] result = new int[2];

		for (int i = 0; i < numbers.length; i++) {
			if (index.containsKey(numbers[i])) {
				result[0] = index.get(numbers[i]);
				result[1] = i + 1;
			} else {
				index.put(target - numbers[i], i + 1);
			}
		}

		return result;
	}
}