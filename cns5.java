import java.io.*;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

public class Main {
    public static void main(String[] args) {
        try {
            // Generate a Blowfish key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
            keyGenerator.init(128); // Key size
            Key secretKey = keyGenerator.generateKey();

            // Initialize the cipher for encryption
            Cipher cipher = Cipher.getInstance("Blowfish/CFB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Read the input file
            FileInputStream fin = new FileInputStream("inputFile.txt");
            FileOutputStream fout = new FileOutputStream("outputFile.txt");
            CipherOutputStream cout = new CipherOutputStream(fout, cipher);

            // Read from the input file and write to the output file
            int input;
            while ((input = fin.read()) != -1) {
                cout.write(input);
            }

            // Close all streams
            fin.close();
            cout.close();
            fout.close();

            System.out.println("File encrypted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
