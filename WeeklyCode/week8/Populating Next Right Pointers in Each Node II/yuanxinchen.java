public class Solution {
  public void connect(TreeLinkNode root) {
    TreeLinkNode first = root;
    while(first != null) {
      TreeLinkNode curt = first, nextLevelFirst = null, nextLevelPrev = null;
      while(curt != null) {
        if(nextLevelFirst == null) {
          nextLevelFirst = curt.left != null ? curt.left : curt.right;
        }
        if(curt.left != null) {
          if(nextLevelPrev != null) {
            nextLevelPrev.next = curt.left;
          }
          nextLevelPrev = curt.left;
        }
        if(curt.right != null) {
          if(nextLevelPrev != null) {
            nextLevelPrev.next = curt.right;
          }
          nextLevelPrev = curt.right;
        }
        curt = curt.next;
      }
      first = nextLevelFirst;
    }
  }
}
