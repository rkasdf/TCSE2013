class solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode preNode = null, curNode = head, preReverseNode = null;

    for (int i = 0; i < m - 1; i++) {
      preNode = curNode;		//m-1th node
      curNode = curNode.next;	//mth node
    }
    preReverseNode = preNode;
    preNode = curNode;
    curNode = curNode.next;

    ListNode tmp;
    for (int i = m; i < n; i++) {
      tmp = curNode.next;
      curNode.next = preNode;
      preNode = curNode;
      curNode = tmp;
    }

    if (preReverseNode != null) {
      preReverseNode.next.next = curNode;
      preReverseNode.next = preNode;
    } else {
      head.next = curNode;
      head = preNode;
    }
    return head;
  }
}
