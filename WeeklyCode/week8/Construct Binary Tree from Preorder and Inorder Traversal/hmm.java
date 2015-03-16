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
    private int preIndex = -1;
    private Map<Integer,Integer> inIdxMap = new HashMap<Integer,Integer>();
    private int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length<1) return null;
        this.preorder = preorder;
        for(int i=0;i<inorder.length;i++){
            inIdxMap.put(inorder[i],i);
        }
        return buildTree(0,preorder.length-1);
    }
    private TreeNode buildTree(int start, int end){
        int val = preorder[++preIndex];
        TreeNode node = new TreeNode(val);
        if(start == end) return node;
        int inIdx = inIdxMap.get(val);
        if(inIdx>start){
            node.left = buildTree(start, inIdx-1);
        }
        if(inIdx<end){
            node.right = buildTree(inIdx+1,end);
        }
        return node;
    }
}