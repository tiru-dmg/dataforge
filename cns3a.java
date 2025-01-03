import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the string and key
        System.out.print("Enter any string: ");
        String str = sc.nextLine();
        System.out.print("Enter the key: ");
        int key = sc.nextInt();

        // Encrypt and display the result
        String encrypted = encrypt(str, key);
        System.out.println("Encrypted string: " + encrypted);

        // Decrypt and display the result
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted string: " + decrypted);

        sc.close();
    }

    public static String encrypt(String str, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + key) % 26 + base);
            }
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    public static String decrypt(String str, int key) {
        return encrypt(str, 26 - (key % 26)); // Decrypt by reversing the shift
    }
}
