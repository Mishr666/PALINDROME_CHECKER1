import java.util.Scanner;
import java.util.Stack;
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome:");
        String inputString = scanner.nextLine();

        // Remove spaces and convert to lower case for a more robust check (optional)
        String cleanString = inputString.replaceAll("\\s", "").toLowerCase();

        // Use the PalindromeChecker method to verify
        if (isPalindrome(cleanString)) {
            System.out.println("The input String \"" + inputString + "\" is a palindrome.");
        } else {
            System.out.println("The input String \"" + inputString + "\" is not a palindrome.");
        }
        scanner.close();
    }

    public static boolean isPalindrome(String str) {
        // Create an empty stack to hold characters
        Stack<Character> stack = new Stack<>();

        // Push each character of the string onto the stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
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
