import java.util.Scanner;
import java.util.Arrays;

public class TextProcessor {

    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    sb.append(word.substring(1).toLowerCase());
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void analyzeText(String text) {
        int charCount = text.replace(" ", "").length();
        int wordCount = text.isEmpty() ? 0 : text.split("\\s+").length;
        int sentenceCount = text.split("[.!?]").length;
        String[] words = text.split("\\s+");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        int[] freq = new int[256];
        for (char c : text.toCharArray()) {
            if (c != ' ') freq[c]++;
        }
        char mostCommon = ' ';
        int max = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                mostCommon = (char) i;
            }
        }
        System.out.println("Characters (no spaces): " + charCount);
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: " + mostCommon);
    }

    public static String[] getWordsSorted(String text) {
        text = text.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = text.split("\\s+");
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph: ");
        String input = scanner.nextLine();

        String cleaned = cleanInput(input);
        System.out.println("\nCleaned Input: " + cleaned);

        System.out.println("\nAnalysis:");
        analyzeText(cleaned);

        String[] sortedWords = getWordsSorted(cleaned);
        System.out.println("\nWords in alphabetical order:");
        for (String word : sortedWords) {
            System.out.println(word);
        }

        System.out.print("\nEnter a word to search: ");
        String search = scanner.nextLine().trim();
        boolean found = false;
        for (String word : sortedWords) {
            if (word.equalsIgnoreCase(search)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Word found!");
        } else {
            System.out.println("Word not found.");
        }
    }
}