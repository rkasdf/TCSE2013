package hty.sqrt;

public class Solution {
	public int sqrt(int x) {
		long result = 0;
		for (int i = 15; i >= 0; i--) {
			if ((result + (1 << i)) * (result + (1 << i)) <= x) {
				result += (1 << i);
			}
		}
		return (int) result;
	}

	public int sqrt2(int x) {
		if (x == 0)
			return 0;

		if (x < 4)
			return 1;

		int result = 0;
		int left = 0;
		int right = x / 2;
		int middle = 0;

		while (left <= right) {
			middle = (left + right) >> 1;
			if (x / middle == middle) {
				return middle;
			} else if (x / middle < middle) {
				right = middle - 1;
			} else {
				left = middle + 1;
				result = middle;
			}
		}

		return result;
	}

	// xi+1= (xi + n/xi) / 2
	public int sqrt3(int x) {
		if (x == 0)
			return 0;
		double pre;
		double cur = 1;

		do {
			pre = cur;
			cur = x / (2 * pre) + pre / 2.0;
		} while (Math.abs(cur - pre) > 0);

		return (int) cur;
	}

}
