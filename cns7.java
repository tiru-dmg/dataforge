import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;

public class BlowFishCipher {
    public static void main(String[] args) {
        try {
            // Create a key generator for Blowfish
            KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
            SecretKey secretKey = keyGenerator.generateKey();

            // Create a cipher instance for Blowfish
            Cipher cipher = Cipher.getInstance("Blowfish");

            // Get user input for the message to encrypt
            String inputText = JOptionPane.showInputDialog("Input your message:");

            // Encrypt the message
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = cipher.doFinal(inputText.getBytes());

            // Decrypt the message
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decrypted = cipher.doFinal(encrypted);

            // Show encrypted and decrypted text
            JOptionPane.showMessageDialog(null,
                    "Encrypted text: " + new String(encrypted) + "\n" +
                    "Decrypted text: " + new String(decrypted));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
