class JumpGame {
  /**
	 * 技止此耳
	 * @param A
	 * @return
	 */
	public boolean canJump2(int[] A) {
		int position = 0, step = A[0];
		while(position < A.length && step != position) {
			int nextStep = 0;
			for(int i = position + 1; i < A.length && i <= step; i++) {
				if(i + A[i] >= A.length - 1) {
					return true;
				}
				nextStep = Math.max(nextStep, i + A[i]);
			}
			position = step;
			step = nextStep;
		}
		return position >= A.length - 1;
	}

	/**
	 * DP: opt[i]表示i能否到达
	 * @param A
	 * @return
	 */
	public boolean canJump3(int[] A) {
		boolean[] opt = new boolean[A.length];
		opt[0] = true;
		for(int i = 1; i < A.length; i++) {
			for(int j = 1; j <= i; j++) {
				if(opt[i - j] && A[i - j] >= j) {
					opt[i] = true;
					break;
				}
			}
		}
		return opt[A.length - 1];
	}

	/**
	 * DP: opt[i]表示到达i时还剩多少步
	 */
	public boolean canJump4(int[] A) {
		int[] opt = new int[A.length];
		for(int i = 1; i < A.length; i++) {
			opt[i] = Math.max(A[i - 1], opt[i - 1]) - 1;
			if(opt[i] < 0) return false;
		}
		return opt[A.length - 1] >= 0;
	}

	/**
	 * 从最后一层开始向前走，看能否下到最底层。
	 */
	public boolean canJump5(int[] A) {
		int post = A.length - 1;
		for(int i = post - 1; i >= 0; i--) {
			if(i + A[i] >= post) {
				post = i;
			}
		}
		return post == 0;
	}
	/**
	 * 贪心。从第一层开始走，能否走到最高层
	 */
	public boolean canJump6(int[] A) {
    //避免死循环
		int post = 1;
		for(int i = 0; i < post && i < A.length; i++) {
			post = Math.max(post, i + A[i] + 1);
		}
		return post >= A.length;
	}
}

class JumpGameII {
  public int jump(int[] A) {
    if(A.length == 1) return 0;
    int res = 1;
    int position = 0, step = A[0];
    while(position < A.length && step != position) {
      if(step >= A.length - 1) return res;
      int nextStep = 0;
      for(int i = position + 1; i < A.length && i <= step; i++) {
        nextStep = Math.max(nextStep, i + A[i]);
      }
      position = step;
      step = nextStep;
      res++;
    }
    return res;
  }
}
