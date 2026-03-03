import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    /**
     * Checks if a given string is a palindrome using a Deque by comparing
     * front and rear elements.
     *
     * @param str The input string to check.
     * @return true if the string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String str) {
        // Use ArrayDeque for efficient insertion and deletion from both ends.
        Deque<Character> charDeque = new ArrayDeque<>();

        // 1. Insert characters into the deque
        for (char c : str.toCharArray()) {
            charDeque.addLast(c); // Add each character to the rear
        }

        // 2. Remove first & last, and compare until empty or a single element remains
        while (charDeque.size() > 1) {
            Character first = charDeque.pollFirst(); // Remove and get the first element
            Character last = charDeque.pollLast();   // Remove and get the last element

            // 3. Compare the elements
            if (!first.equals(last)) {
                return false; // Mismatch found, not a palindrome
            }
        }

        // If the loop completes without a mismatch, the string is a palindrome.
        return true;
    }

    public static void main(String[] args) {
        String testString1 = "madam";
        String testString2 = "hello";
        String testString3 = "radar";

        System.out.println("Is \"" + testString1 + "\" a palindrome? " + isPalindrome(testString1));
        System.out.println("Is \"" + testString2 + "\" a palindrome? " + isPalindrome(testString2));
        System.out.println("Is \"" + testString3 + "\" a palindrome? " + isPalindrome(testString3));
    }
}
