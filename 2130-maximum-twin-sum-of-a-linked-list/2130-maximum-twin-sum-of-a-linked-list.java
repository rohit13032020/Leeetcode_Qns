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
    public int pairSum(ListNode head) {
        ListNode mid = find_mid(head);
        // reverse the haf list
        ListNode second_half = reverse_list(mid);
        ListNode first_half = head;

        int max_Sum = 0;

        while(second_half!=null){
            max_Sum = Math.max(max_Sum,first_half.val+second_half.val);
            first_half = first_half.next;
            second_half = second_half.next;

        }
        return max_Sum;

    }

    // mid function
    private ListNode find_mid(ListNode head){
       ListNode slow = head;
       ListNode fast = head;

       while(fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
       }
       return slow;
    }

    //reverse function
    private ListNode reverse_list(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!= null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}