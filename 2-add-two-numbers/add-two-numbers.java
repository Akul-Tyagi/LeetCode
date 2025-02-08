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
public class Solution {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize a dummy node to simplify the result list manipulation.
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        // Continue while there are digits in l1, l2, or a carry remains.
        while (l1 != null || l2 != null || carry != 0) {
            // Start with the carry value.
            int sum = carry;
            
            // Add the value from l1 if it is present.
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            // Add the value from l2 if it is present.
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            // Compute the new carry for the next iteration.
            carry = sum / 10;
            
            // Create a new node with the digit value (sum modulo 10) and append it to the result.
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        // The dummy node's next pointer points to the head of the new list.
        return dummy.next;
    }
}