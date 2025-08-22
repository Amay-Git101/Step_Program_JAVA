public class StringManipulation {
    public static void main(String[] args) {

        String str1 = "Java Programming";

        String str2 = new String("Java Programming");

        char[] chars = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        String str3 = new String(chars);

        System.out.println("str1 == str2: " + (str1 == str2)); // false, different objects
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // true, same content
        System.out.println("str1 == str3: " + (str1 == str3)); // false, different objects
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true, same content

        System.out.println("\nExplanation:");
        System.out.println("The '==' operator checks if both references point to the same object.");
        System.out.println("The '.equals()' method checks if the contents of the strings are the same.");

        String quote = "Programming Quote:\n\t\"Code is poetry\" - Unknown\n\tPath: C:\\Java\\Projects";
        System.out.println("\n" + quote);
    }
}