import java.util.Scanner;

public class Main {
    static float[][] key = new float[3][3];
    static float[][] inverseKey = new float[3][3];
    static float[][] message = new float[3][1];
    static float[][] encrypted = new float[3][1];
    static float[][] decrypted = new float[3][1];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        getInput();
        encryptMessage();
        System.out.print("\nEncrypted string is: ");
        for (int i = 0; i < 3; i++) {
            System.out.print((char) (encrypted[i][0] % 26 + 97));
        }
        calculateInverse();
        decryptMessage();
        System.out.print("\nDecrypted string is: ");
        for (int i = 0; i < 3; i++) {
            System.out.print((char) (decrypted[i][0] % 26 + 97));
        }
    }

    private static void getInput() {
        System.out.println("Enter a 3x3 key matrix (must be invertible): ");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                key[i][j] = scanner.nextFloat();

        System.out.print("\nEnter a 3-letter string: ");
        String msg = scanner.next();
        for (int i = 0; i < 3; i++)
            message[i][0] = msg.charAt(i) - 97;
    }

    private static void encryptMessage() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                encrypted[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    encrypted[i][j] += key[i][k] * message[k][j];
                }
            }
        }
    }

    private static void calculateInverse() {
        float temp;
        float[][] tempKey = new float[3][3];
        for (int i = 0; i < 3; i++)
            System.arraycopy(key[i], 0, tempKey[i], 0, 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverseKey[i][j] = (i == j) ? 1 : 0;
            }
        }

        for (int i = 0; i < 3; i++) {
            temp = tempKey[i][i];
            for (int j = 0; j < 3; j++) {
                tempKey[i][j] /= temp;
                inverseKey[i][j] /= temp;
            }
            for (int k = 0; k < 3; k++) {
                if (i != k) {
                    temp = tempKey[k][i];
                    for (int j = 0; j < 3; j++) {
                        tempKey[k][j] -= tempKey[i][j] * temp;
                        inverseKey[k][j] -= inverseKey[i][j] * temp;
                    }
                }
            }
        }

        System.out.println("\nInverse Matrix is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(inverseKey[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void decryptMessage() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                decrypted[i][j] = 0;
                for (int k = 0; k < 3; k++) {
                    decrypted[i][j] += inverseKey[i][k] * encrypted[k][j];
                }
            }
        }
    }
}
