public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return buildNode(1,n);
    }
    public List<TreeNode> buildNode(int start, int end){
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        if(end<start){
            nodeList.add(null);
            return nodeList;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> leftChilds = buildNode(start,i-1);
            List<TreeNode> rightChilds = buildNode(i+1,end);
            for(TreeNode left:leftChilds){
                for(TreeNode right:rightChilds){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    nodeList.add(root);
                }
            }
        }
        return nodeList;
    }
}