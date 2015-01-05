public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode currNode = head, result = null, resultIndex = null;
        boolean preEqual = false;
        while(currNode != null){
            if(!preEqual && (currNode.next == null || currNode.val != currNode.next.val)){
                //has
                if(result == null){
                    result = currNode;
                    resultIndex = result;
                }else{
                    resultIndex.next = currNode;
                    resultIndex = resultIndex.next;
                }
                currNode = currNode.next;
                resultIndex.next = null;//clear the result
            }else{
                //no
                if(currNode.next != null && currNode.val == currNode.next.val){
                    preEqual = true;
                }else{
                    preEqual = false;
                }
                currNode = currNode.next;
            }
        }
        return result;
    }
}