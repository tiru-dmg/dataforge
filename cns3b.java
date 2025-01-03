import java.util.Scanner;

public class SubstitutionCipher {
    public static void main(String[] args) {
        // Define the substitution mappings
        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "zyxwvutsrqponmlkjihgfedcba";

        // Take input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any string: ");
        String input = sc.nextLine().toLowerCase();

        // Encrypt the input string
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = a.indexOf(c);
                encrypted.append(b.charAt(index));
            } else {
                encrypted.append(c); // Keep non-alphabet characters as is
            }
        }

        // Print the result
        System.out.println("The encrypted data is: " + encrypted);
        sc.close();
    }
}
