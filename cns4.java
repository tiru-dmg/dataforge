import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class SimpleDES {
    private static SecretKey secretKey;
    private static Cipher cipher;

    public static void main(String[] args) throws Exception {
        // Initialize the cipher and key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56); // Key size for DES
        secretKey = keyGenerator.generateKey();
        cipher = Cipher.getInstance("DES");

        Scanner scanner = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the string to encrypt: ");
        String input = scanner.nextLine();

        // Encrypt and decrypt the input string
        String encrypted = encrypt(input);
        String decrypted = decrypt(encrypted);

        // Print the results
        System.out.println("Encrypted Value: " + encrypted);
        System.out.println("Decrypted Value: " + decrypted);

        scanner.close();
    }

    public static String encrypt(String plainText) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }
}
