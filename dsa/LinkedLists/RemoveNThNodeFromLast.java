// 19. Remove Nth Node From End of List
// Solved
// Medium
// Topics
// Companies
// Hint
// Given the head of a linked list, remove the nth node from the end of the list and return its head.


  // Definition for singly-linked list.

public class RemoveNThNodeFromLast {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode dummy = res;

        for (int i=0; i<n; i++){
          head = head.next;
        }
        while (head != null){
          head = head.next;
          dummy = dummy.next;
        }

        dummy = dummy.next.next;
        return res.next;
    }
}