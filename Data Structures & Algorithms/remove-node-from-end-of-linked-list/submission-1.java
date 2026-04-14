/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode slow = temp;
        ListNode fast = temp;


        for(int i = 0 ; i <= n ; i++){
            if(fast!=null){
                fast = fast.next;
            }else{
                return head;
            }
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        if(slow.next!=null) slow.next = slow.next.next;

        return temp.next;
        

    }
}
