import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class SimpleRSA {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Read prime numbers p and q from the user
        System.out.print("Enter a prime number p: ");
        BigInteger p = sc.nextBigInteger();

        System.out.print("Enter another prime number q: ");
        BigInteger q = sc.nextBigInteger();

        // Calculate n and phi(n)
        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        // Generate the public key (e, n)
        BigInteger e = generateE(phi);

        // Calculate the private key d
        BigInteger d = e.modInverse(phi);

        // Output the keys
        System.out.println("Public key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private key (d, n): (" + d + ", " + n + ")");
    }

    // Method to generate e such that gcd(e, phi(n)) = 1
    public static BigInteger generateE(BigInteger phi) {
        Random rand = new Random();
        BigInteger e;
        do {
            e = new BigInteger(phi.bitLength(), rand); // Random e of appropriate size
        } while (e.compareTo(phi) >= 0 || e.gcd(phi).intValue() != 1); // Ensure gcd(e, phi) = 1
        return e;
    }
}
