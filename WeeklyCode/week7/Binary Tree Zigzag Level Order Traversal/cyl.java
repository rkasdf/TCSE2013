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
        List<List<TreeNode>> levels = new ArrayList<List<TreeNode>>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root==null)
            return ret;
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        int level = 0;
        levels.add(nodes);
        
        for(int i=0;;i++){
            nodes = levels.get(i);
            List<TreeNode> childs = new ArrayList<TreeNode>();
            for(int j=0;j<nodes.size();j++){
                TreeNode father = nodes.get(j);
                if(father.left!=null)
                    childs.add(father.left);
                if(father.right!=null)
                    childs.add(father.right);
            }
            if(childs.size()==0)
                break;
            levels.add(childs);
        }
        
        for(int i=0;i<levels.size();i++){
            nodes = levels.get(i);
            int j=0,step =1;
            if(i%2==1){
                j=nodes.size()-1;
                step = -1;
            }
            List<Integer> vals = new ArrayList<Integer>();
            for(;j>=0&&j<nodes.size();j+=step){
                vals.add(nodes.get(j).val);
            }
            ret.add(vals);
        }
        return ret;
    }
}
