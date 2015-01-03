package iscas.leetcode.hty.duplicatelist2;

/**
 * Created by hty on 2015/1/3.
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 记于最后，这个题看上去极简单无比，所以，就根据所思所想，一步一步写了下去，当然很多特殊情况就没有考虑到，而后
     * 当出现bad case 的时候，就硬编码的去改代码，把bad case一个一个的以if-else的方式pass掉。
     * 虽然这样也能解决问题，但是，代码整体的可维护性变的特别差，而且在不断加条件的过程中，时间不省反增。
     * 平时工程中，也常常有这种问题，比如新建虚拟机的失败条件回滚(- -)，为什么你宁可一次一次的改，而不把这段代码封装的
     * 优雅一些，通用性更强一些呢？！(……现在就去改了啦-。-)
     * 封装一个通用性很强的方法，这样不仅代码便于维护，也会减少很多冗余代码，而且鲁棒性很强&&省时省力！！！
     * 往往就是很懒，不愿意去进一步思考，想当然的为了解决问题而解决问题，就导致了代码变成一个坑，一个让后人骂的坑，看似
     * 后人在不断的填土，其实，是在挖一个更大的天坑；留下bad case还好说，还可以重构，bad case都没有，那就只能呵呵呵了……
     * 谨以为戒！
     */

    //In front of the high-energy, noncombatant please evacuate quickly
    //I can believe the code from me, until now.
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode temp = head.next;
        boolean flag = false;
        ListNode pre = head;
        boolean temflag = false;

        while (temp != null) {
            if (head.val == temp.val) {             //It is not necessary to find the location of head
                flag = true;                        //abstract it to note
                temp = temp.next;                   //it is similar to "Remove Duplicates From Array II"
                continue;                           //but the boundary condition is different
            } else {
                if (flag) {                         //remove this block
                    head = temp;
                    flag = false;
                    temp = temp.next;
                    pre = head;
                    continue;
                } else {
                    if (temp.next == null)              //extract this block to be boundary condition
                        break;
                    if (temp.val == temp.next.val) {    //extract this block to be condition
                        temflag = true;
                        temp = temp.next;
                        continue;
                    } else {
                        if (temflag) {
                            temp = temp.next;
                            temflag = false;
                            continue;
                        }
                        pre.next = temp;
                        pre = temp;
                        temp = temp.next;           //this is the same operation
                    }
                }
            }
        }

        if (flag)
            return null;

        if (!temflag && temp != null && pre.val != temp.val) {  //It is ugly! Hard coding!!
            pre.next = temp;
        }

        if (temflag)
            pre.next = null;

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode temphead = new ListNode(-1);
        temphead.next = head;
        ListNode note = temphead;
        ListNode prev = temphead;
        ListNode find = head;

        while (find != null) {
            if ((prev.equals(temphead) || prev.val != find.val) && (find.next == null || find.val != find.next.val)) {
                note = note.next = find;
            }
            prev = find;
            find = find.next;
        }

        note.next = null;
        return temphead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
