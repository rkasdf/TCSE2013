public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> ltr = new Stack<>(), rtl = new Stack<>(), tmp;
        ltr.push(root);
        boolean order = true;

        while (!ltr.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!ltr.isEmpty()) {
                TreeNode node = ltr.pop();
                list.add(node.val);
                if (order) {
                    if (node.left != null)
                        rtl.push(node.left);
                    if (node.right != null)
                        rtl.push(node.right);
                } else {
                    if (node.right != null)
                        rtl.push(node.right);
                    if (node.left != null)
                        rtl.push(node.left);
                }
            }
            tmp = ltr;
            ltr = rtl;
            rtl = tmp;
            order = !order;
            result.add(list);
        }

        return result;
    }
}
