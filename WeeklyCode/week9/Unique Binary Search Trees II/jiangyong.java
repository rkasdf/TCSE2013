/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    
    public List<TreeNode> generate(int begin, int end) {
        List <TreeNode> result = new ArrayList<TreeNode>();
        if (begin > end) {
            result.add(null);
            return result;
        }
        List <TreeNode> left = new ArrayList<TreeNode>();
        List <TreeNode> right = new ArrayList<TreeNode>();
        for (int i = begin; i <= end; i++) {
            left = generate(begin, i - 1);
            right = generate(i + 1, end);
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
