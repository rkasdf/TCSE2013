public class Solution {
  public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int res = 0;
		Deque<TreeNode> deque = new LinkedList<>();
		deque.add(root);
		while (!deque.isEmpty()) {
			res++;
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = deque.pollFirst();
				if (node.left == null && node.right == null) {
					return res;
				}
				if (node.left != null) {
					deque.addLast(node.left);
				}
				if (node.right != null) {
					deque.addLast(node.right);
				}
			}
		}
		return res;
	}

	public int minDepthRecursive(TreeNode root) {
		if (root == null)
			return 0;
		int left = minDepthRecursiez(root.left);
		int right = minDepthRecursiez(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left,
				right) + 1;
	}
}
