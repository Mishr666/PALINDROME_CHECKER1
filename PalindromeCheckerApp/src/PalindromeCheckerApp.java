import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    // Node class for the singly linked list
    static class ListNode {
        char val;
        ListNode next;
        ListNode(char val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Converts a string to a singly linked list.
     */
    public static ListNode convertStringToList(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        ListNode head = new ListNode(s.charAt(0));
        ListNode current = head;
        for (int i = 1; i < s.length(); i++) {
            current.next = new ListNode(s.charAt(i));
            current = current.next;
        }
        return head;
    }

    /**
     * Reverses a singly linked list in-place.
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * Checks if the singly linked list is a palindrome.
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // An empty or single-node list is a palindrome
        }

        // 1. Find the middle of the linked list using fast and slow pointers.
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse the second half of the linked list.
        // If the list has an odd number of nodes, slow is at the true middle,
        // the second half starts from slow.next.
        // If even, slow is the end of the first half, second half starts from slow.next.
        ListNode secondHalfHead = reverseList(slow.next);
        ListNode firstHalfHead = head;

        // 3. Compare the first and second halves.
        ListNode secondHalfCurrent = secondHalfHead;
        while (secondHalfCurrent != null) {
            if (firstHalfHead.val != secondHalfCurrent.val) {
                // Optional: Restore the list (as per flow instructions)
                // reverseList(secondHalfHead); // Reverse back
                // slow.next = secondHalfHead;  // Reconnect
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            secondHalfCurrent = secondHalfCurrent.next;
        }

        // Optional: Restore the list (as per flow instructions)
        // reverseList(secondHalfHead); // Reverse back
        // slow.next = secondHalfHead;  // Reconnect
        return true;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        String s1 = "racecar";
        ListNode head1 = convertStringToList(s1);
        System.out.println("String \"" + s1 + "\" is palindrome: " + isPalindrome(head1));

        String s2 = "hello";
        ListNode head2 = convertStringToList(s2);
        System.out.println("String \"" + s2 + "\" is palindrome: " + isPalindrome(head2));

        String s3 = "abccba";
        ListNode head3 = convertStringToList(s3);
        System.out.println("String \"" + s3 + "\" is palindrome: " + isPalindrome(head3));
    }
}
