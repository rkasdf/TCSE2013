public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0,sum = 0;
        ListNode next1 = l1, next2 = l2;
        ListNode result = null, resultIterator = null;
        while(next1 != null || next2 != null || carry != 0 ){
            sum = carry;
            if(next1 != null){
                sum += next1.val;
                next1 = next1.next;
            }
            if(next2 != null){
                sum += next2.val;
                next2 = next2.next;
            }
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
        }
        return result;
    }
}