public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size()<1) return null;
        Iterator<ListNode> it = lists.iterator();
        while(lists.size()>1){
            ListNode listNode1 = it.next();
            it.remove();
            ListNode listNode2 = it.next();
            it.remove();
            lists.add(merge2List(listNode1,listNode2));
            it = lists.iterator();
        }
        return lists.get(0);
    }
    private ListNode merge2List(ListNode listNode1, ListNode listNode2){
        ListNode vHead = new ListNode(-1),it1 = vHead,temp;
        vHead.next = listNode1;
        while(it1.next != null && listNode2 != null){
            if(it1.next.val > listNode2.val){
                temp = listNode2.next;
                listNode2.next = it1.next;
                it1.next = listNode2;
                listNode2 = temp;
            }else{
                it1 = it1.next;
            } 
        }
        if(listNode2 != null){
            it1.next = listNode2;
        }
        return vHead.next;
    }
}