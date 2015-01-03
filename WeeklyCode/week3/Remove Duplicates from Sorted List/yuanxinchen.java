class solution {
  public ListNode deleteDuplicates(ListNode head) {
        ListNode preNode = null, curNode = head;
        ListNode lastUnique = head = null;
        while(curNode != null) {
            if((preNode == null || curNode.val != preNode.val) && (curNode.next == null || curNode.val != curNode.next.val)) {
            if(lastUnique != null) {
              lastUnique.next = curNode;
            }
            lastUnique = curNode;
            }
      if(head == null) {
        head = lastUnique;
      }
            preNode = curNode;
      curNode = curNode.next;
      if(lastUnique != null) {
        lastUnique.next = null;
      }
        }
        return head;
    }
}
