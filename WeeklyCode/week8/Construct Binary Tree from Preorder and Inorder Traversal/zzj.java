public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return digui(preorder, inorder);
    }
    public TreeNode digui(int[] preorder, int[] inorder){
        int n = preorder.length;
        if(n==0) return null;
        if(n==1){
            return new TreeNode(preorder[0]);
        }else{
            TreeNode root = new TreeNode(preorder[0]);
            int pos = 0;
            for(int i = 0; i < n; i++){
                if(inorder[i]==preorder[0]){
                    pos = i;
                }
            }
            if(pos!=0){
                int[] pre = new int[pos];
                for(int i = 0; i < pos; i++){
                    pre[i] = preorder[i+1];
                }
                int[] in = new int[pos];
                for(int i = 0; i < pos; i++){
                    in[i] = inorder[i];
                }
                root.left = digui(pre,in);
            }
            if(pos!=n-1){
                int[] pre = new int[n-pos-1];
                int[] in = new int[n-pos-1];
                for(int i = 0; i < n-pos-1; i++){
                    pre[i] = preorder[i+pos+1];
                    in[i] = inorder[i+pos+1];
                }
                root.right = digui(pre,in);
            }
            return root;
        }
    }
}
