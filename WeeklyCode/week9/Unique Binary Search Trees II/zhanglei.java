public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> ltrees = generateTrees(start, i - 1);
            List<TreeNode> rtrees = generateTrees(i + 1, end);
            for (TreeNode left : ltrees) {
                for (TreeNode right : rtrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }

        return result;
    }
}