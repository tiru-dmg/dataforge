import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Accept input message from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter message to encrypt: ");
        String message = scanner.nextLine();

        // Generate key
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        SecretKey skey = kgen.generateKey();

        // Encrypt message
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skey);
        byte[] encrypted = cipher.doFinal(message.getBytes());
        String encryptedString = Base64.getEncoder().encodeToString(encrypted);
        System.out.println("Encrypted: " + encryptedString);

        // Decrypt message
        cipher.init(Cipher.DECRYPT_MODE, skey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
        String decryptedMessage = new String(decrypted);
        System.out.println("Decrypted: " + decryptedMessage);

        scanner.close();
    }
}
