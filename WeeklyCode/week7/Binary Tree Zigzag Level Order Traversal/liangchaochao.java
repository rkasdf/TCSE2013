/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> valueList = new LinkedList<>();
        if(root == null) return valueList;
        
        LinkedList<List<TreeNode>> nodeList = new LinkedList<>();
        List<TreeNode> rootList = new LinkedList<>();
        rootList.add(root);
        nodeList.add(rootList);
        boolean left = false;
        List<TreeNode> traverList;
        while(!nodeList.isEmpty() && (traverList = nodeList.poll()) != null ){
            LinkedList<TreeNode> leafTreeNodes = new LinkedList<>();
            List<Integer> values = new LinkedList<>();
            for(TreeNode node: traverList){
                values.add(node.val);
                if(!left){
                    if(node.left != null) leafTreeNodes.add(0,node.left);
                    if(node.right != null) leafTreeNodes.add(0,node.right);
                }
                else{
                    if(node.right != null) leafTreeNodes.add(0,node.right);
                    if(node.left != null) leafTreeNodes.add(0,node.left);
                }
            }
            left = !left;
            if(!leafTreeNodes.isEmpty()) nodeList.add(leafTreeNodes);
            if(!values.isEmpty()) valueList.add(values);
        }
        
        return valueList;
    }
}
