public class Solution {
  public List<TreeNode> generateTreesBackTracking(int n) {
		return generateTrees(1, n);
	}

	private List<TreeNode> generateTrees(int left, int right) {
		List<TreeNode> res = new ArrayList<>();
		if (left > right) {
			res.add(null);
			return res;
		}
		for (int i = left; i <= right; i++) {
			List<TreeNode> leftNodes = generateTrees(left, i - 1);
			List<TreeNode> rightNodes = generateTrees(i + 1, right);
			for (TreeNode leftNode : leftNodes) {
				for (TreeNode rightNode : rightNodes) {
					TreeNode root = new TreeNode(i);
					root.left = leftNode;
					root.right = rightNode;
					res.add(root);
				}
			}
		}
		return res;
	}

	public List<TreeNode> generateTreesDP(int n) {
		List<List<TreeNode>> trees = new ArrayList<>();
		List<TreeNode> res = null, ele0 = new ArrayList<>(), ele1 = new ArrayList<>();
		ele0.add(null);
		ele1.add(new TreeNode(0));
		trees.add(ele0);
		trees.add(ele1);
		for(int itr = 2; itr <= n; itr++) {
			trees.add(new ArrayList<>());
			for(int root = 1; root <= itr; root++) {
				for(TreeNode leftTree : trees.get(root - 1)) {
					for(TreeNode rightTree : trees.get(itr - root)) {
						TreeNode newTree = new TreeNode(0);
						newTree.left = cloneTree(leftTree);
						newTree.right = cloneTree(rightTree);
						trees.get(itr).add(newTree);
					}
				}
			}
		}
		//update the value for every tree
		res = trees.get(n);
		for(TreeNode tree : res) {
			List<TreeNode> inorderList = new ArrayList<>();
			inorder(tree, inorderList);
			int value = 1;
			for(TreeNode node : inorderList) {
				node.val = value++;
			}
		}
		return res;
	}

	private void inorder(TreeNode root, List<TreeNode> list) {
		if(root == null) {
			return;
		}
		inorder(root.left, list);
		list.add(root);
		inorder(root.right, list);
	}

	private TreeNode cloneTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		Map<TreeNode, TreeNode> map = new HashMap<>();
		TreeNode res = new TreeNode(root.val);
		map.put(root, res);
		Deque<TreeNode> deque = new LinkedList<>();
		deque.addLast(root);
		while(!deque.isEmpty()) {
			int size = deque.size();
			for(int i = 0; i < size; i++) {
				TreeNode curt = deque.pollFirst();
				TreeNode newCurt = map.get(curt);
				if(curt.left != null) {
					TreeNode left = new TreeNode(curt.left.val);
					newCurt.left = left;
					map.put(curt.left, left);
					deque.addLast(curt.left);
				}
				if(curt.right != null) {
					TreeNode right = new TreeNode(curt.right.val);
					newCurt.right = right;
					map.put(curt.right, right);
					deque.addLast(curt.right);
				}
			}
		}
		return res;
	}
}
