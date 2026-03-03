import java.util.Scanner;
public class PalindromeChecker {

    public static boolean isPalindrome(String original) {
        String reversed = "";

        // Loop through the original string in reverse order
        for (int i = original.length() - 1; i >= 0; i--) {
            // Concatenate each character to the reversed string
            reversed += original.charAt(i);
        }

        // Compare the original and reversed strings
        // The equals() method compares content, not memory addresses
        return original.equals(reversed);
    }

    public static void main(String[] args) {
        String testString1 = "madam";
        String testString2 = "hello";

        System.out.println("Is \"" + testString1 + "\" a palindrome? " + isPalindrome(testString1));
        System.out.println("Is \"" + testString2 + "\" a palindrome? " + isPalindrome(testString2));
    }
}

