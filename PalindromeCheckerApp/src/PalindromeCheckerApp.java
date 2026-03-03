import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // --- Key Concepts ---
        // Queue: FIFO (First-In, First-Out)
        // Stack: LIFO (Last-In, First-Out)
        String word = "HELLO";

        // 1. Enqueue characters to a Queue
        Deque<Character> queue = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            queue.addLast(c); // Enqueue operation (add to rear)
        }

        // 2. Push characters to a Stack
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            stack.push(c); // Push operation (add to top)
        }

        System.out.println("Original Word: " + word);
        System.out.println("Queue (FIFO) elements: " + queue);
        System.out.println("Stack (LIFO) elements: " + stack);
        System.out.println("\n--- Dequeue (Queue) vs Pop (Stack) Comparison ---");

        // 3. Compare dequeue vs pop
        while (!queue.isEmpty() || !stack.isEmpty()) {
            // Dequeue: Removes the element from the front of the queue
            Character dequeued = null;
            if (!queue.isEmpty()) {
                dequeued = queue.removeFirst();
            }

            // Pop: Removes the element from the top of the stack
            Character popped = null;
            if (!stack.isEmpty()) {
                popped = stack.pop();
            }

            System.out.println("Dequeued (FIFO): " + dequeued + " | Popped (LIFO): " + popped);

            // 4. Logical Comparison (Palindrome check implication)
            // If the dequeued item matches the popped item for all elements,
            // the original word would be a palindrome.
            if (dequeued != null && popped != null && dequeued.equals(popped)) {
                System.out.println("  -> Match found: The start and end characters are the same.");
            } else if (dequeued != null && popped != null) {
                System.out.println("  -> Mismatch: The start and end characters are different.");
            }
        }

        // Pop characters from the stack to build the reversed string
        String reverseString = "";
        while (!stack.isEmpty()) {
            reverseString += stack.pop();
        }

        // Compare the original string with the reversed string
        return str.equals(reverseString);
    }
}
