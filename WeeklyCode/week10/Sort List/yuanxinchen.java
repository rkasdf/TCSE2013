public class SortList {
	public ListNode sortListBottomUp(ListNode head) {
			if (head == null) {
				return null;
			}
			int size = 0;
			ListNode tail = head;
			while (tail != null) {
				size++;
				tail = tail.next;
			}
			ListNode res = new ListNode(0), left, right, curt;
			res.next = head;
			for (int i = 1; i < size; i = i << 1) {
				curt = res.next;
				tail = res;
				while (curt != null) {
					left = curt;
					right = getNextNth(curt, i);
					curt = getNextNth(right, i);
					tail = merge(left, right, tail);
				}
			}
			return res.next;
		}

		private ListNode getNextNth(ListNode head, int n) {
			ListNode res = null;
			for (int i = 1; head != null && i < n; i++) {
				head = head.next;
			}
			if (head == null) {
				return null;
			}
			res = head.next;
			head.next = null;
			return res;
		}

		private ListNode merge(ListNode list1, ListNode list2, ListNode tail) {
			ListNode l1 = list1, l2 = list2, curt = tail;
			while (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					curt.next = l1;
					l1 = l1.next;
				} else {
					curt.next = l2;
					l2 = l2.next;
				}
				curt = curt.next;
			}
			curt.next = l1 != null ? l1 : l2;
			return curt;
		}

		public ListNode sortList(ListNode head) {
			if (head == null) {
				return null;
			}
			ListNode tail = head;
			while (tail.next != null) {
				tail = tail.next;
			}
			return sort(head);
		}

		private ListNode sort(ListNode head) {
			if (head == null || head.next == null) {
				return head;
			}
			ListNode slow = head, fast = head;
			while (fast.next != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			ListNode rightHead = slow.next;
			slow.next = null;
			ListNode leftList = sort(head);
			ListNode rightList = sort(rightHead);
			return merge(leftList, rightList);
		}

		private ListNode merge(ListNode list1, ListNode list2) {
			ListNode result = new ListNode(0), curt = result;
			ListNode i = list1, j = list2;
			while (i != null && j != null) {
				if (i.val < j.val) {
					curt.next = i;
					i = i.next;
				} else {
					curt.next = j;
					j = j.next;
				}
				curt = curt.next;
			}
			curt.next = i != null ? i : j;
			return result.next;
		}
}
