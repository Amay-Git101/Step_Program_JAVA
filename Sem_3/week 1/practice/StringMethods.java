import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name (first and last name): ");
        String fullName = scanner.nextLine().trim();

        System.out.print("Enter your favorite programming language: ");
        String favLang = scanner.nextLine().trim();

        System.out.print("Describe your programming experience in a sentence: ");
        String experience = scanner.nextLine().trim();

        String[] nameParts = fullName.split("\\s+");
        String firstName = nameParts.length > 0 ? nameParts[0] : "";
        String lastName = nameParts.length > 1 ? nameParts[1] : "";

       
        int charCount = experience.replace(" ", "").length();

        String favLangUpper = favLang.toUpperCase();

        System.out.println("\n--- Summary ---");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Programming Language: " + favLangUpper);
        System.out.println("Experience Sentence: " + experience);
        System.out.println("Character count (excluding spaces): " + charCount);

        scanner.close();
    }
}