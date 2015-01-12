public class LinkedListCycleII {
	
	private ListNode move(ListNode node,int count) {
		while((count--)!=0){
			node = node.next;
		}
		return node;
	}	
	
	//O(n^2)
	public  ListNode detectCycle(ListNode head) {
		if(head == null) return null;
		ListNode single = head;
		ListNode node = null;
		ListNode dual = head;
		
		while(dual!=null && dual.next != null){
			single = single.next;
			dual = dual.next.next;
			if(single == dual){
				node = single;
				break;
			}
		}
		
		if(dual == null || dual.next == null){
			 return null;
		}
		
		ListNode curNode = node.next;
		int count = 1;
		while(curNode != node){
			count++;
			curNode=curNode.next;
		}
		
		curNode = head;
		while(curNode != move(curNode, count)){
			curNode = curNode.next;
		}
		return curNode;    
    }
	
	//O(nlogn) 找到相遇点后二分 头结点到相遇点之间的节点，直到找到环的入口点
	public  ListNode detectCycle2(ListNode head) {
		if(head == null) return null;
		ListNode single = head;
		ListNode node = null;
		ListNode dual = head;
		int sum=0;
		while(dual!=null && dual.next != null){
			sum++;
			single = single.next;
			dual = dual.next.next;
			if(single == dual){
				node = single;
				break;
			}
		}
		
		if(dual == null || dual.next == null){
			 return null;
		}
		
		ListNode curNode = node.next;
		int count = 1;
		while(curNode != node){
			count++;
			curNode=curNode.next;
		}
		
		int l = 0, r = sum;
		ListNode head2= head;
		while(l<r){
			int mid = (l+r)/2;
			curNode = move(head2, mid-l);
			if(curNode != move(curNode, count)){
				l = mid + 1;
				head2 = curNode.next;
			}else{
				r = mid;
			}
		}
		return head2;    
    }
	
	//O(n) 参考题解
	public ListNode detectCycle3(ListNode head) {
		if(head == null) return null;
		ListNode single = head;
		ListNode dual = head;		
		while(dual!=null && dual.next != null){			
			single = single.next;
			dual = dual.next.next;
			if(single == dual){
				ListNode node = head;
				while(node != single){
					node = node.next;
					single = single.next;
				}
				return node;
			}
		}			
		return null ;    
    }
}
