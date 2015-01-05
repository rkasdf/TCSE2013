public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0,sum,val1,val2;
        ListNode next1 = l1, next2 = l2;
        ListNode result = null, resultIterator = null;
        while(next1 != null || next2 != null || carry != 0 ){
            val1 = next1 == null ? 0 : next1.val;
            val2 = next2 == null ? 0 : next2.val;
            sum = val1 + val2 + carry;
            carry = sum/10;
            sum = sum%10;
            ListNode resultNext = new ListNode(sum);
            if(result == null){
                result = resultNext;
                resultIterator = result;
            }else{
                resultIterator.next = resultNext;
                resultIterator = resultNext;
            }
            next1 = next1 == null ? null : next1.next;
            next2 = next2 == null ? null : next2.next;
        }
        return result;
        
    }
}