import java.util.Scanner;
public class PalindromeCheckerApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word to check for palindrome string or not:");
        String Word = "madam";
        boolean isPalindrome = true;

        for (int i=0; i < Word.length() / 2; i++){
            if (Word.charAt(i) != Word.charAt(Word.length() -1 -i)){
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome){
            System.out.println(Word + "is a palindrome");
        } else{
            System.out.println(Word +" is not a palindrome");
        }
    }
}