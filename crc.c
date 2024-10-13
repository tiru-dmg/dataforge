#include <stdio.h>
#include <string.h>
void xor_division(char dividend[], const char divisor[], int divisor_len) {
    int i, j;
    for (i = 0; dividend[i + divisor_len - 1] != '\0'; i++) {
        if (dividend[i] == '1') {
            for (j = 0; j < divisor_len; j++) {
                dividend[i + j] = (dividend[i + j] == divisor[j]) ? '0' : '1';}}}}
int main() {
    char message[100], generator[30], encoded[130], remainder[30];
    int message_len, generator_len, i;
    printf("Enter message (binary): ");
    scanf("%s", message);
    printf("Enter generator (binary): ");
    scanf("%s", generator);
    message_len = strlen(message);
    generator_len = strlen(generator);
    strcpy(encoded, message);
    for (i = 0; i < generator_len - 1; i++) {
        strcat(encoded, "0");
    }
    strcpy(remainder, encoded);
    xor_division(remainder, generator, generator_len);
    strncpy(remainder, &remainder[message_len], generator_len - 1);
    remainder[generator_len - 1] = '\0';
    printf("Calculated CRC: %s\n", remainder);
    strcat(message, remainder);
    printf("\nVerification:\n");
    printf("Encoded message (message + CRC): %s\n", message);
    strcpy(encoded, message);
    xor_division(encoded, generator, generator_len);
    for (i = 0; i < generator_len - 1; i++) {
        if (encoded[message_len + i] != '0') {
            printf("CRC Verification: Failed (Remainder is %s)\n", &encoded[message_len]);
            return 0;
        }
    }
    printf("CRC Verification: Passed (Remainder is zero)\n");

    return 0;
}
