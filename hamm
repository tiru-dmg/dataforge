#include <stdio.h>
void calculateHammingCode(int dataBits[4], int hammingCode[7]) {
hammingCode[2] = dataBits[0];
hammingCode[4] = dataBits[1];
hammingCode[5] = dataBits[2];
hammingCode[6] = dataBits[3];
hammingCode[0] = hammingCode[2] ^ hammingCode[4] ^ hammingCode[6];
hammingCode[1] = hammingCode[2] ^ hammingCode[5] ^ hammingCode[6];
hammingCode[3] = hammingCode[4] ^ hammingCode[5] ^ hammingCode[6];
}
int detectError(int receivedCode[7]) {
int P1, P2, P4, errorPosition = 0;
P1 = receivedCode[0] ^ receivedCode[2] ^ receivedCode[4] ^ receivedCode[6];
P2 = receivedCode[1] ^ receivedCode[2] ^ receivedCode[5] ^ receivedCode[6];
P4 = receivedCode[3] ^ receivedCode[4] ^ receivedCode[5] ^ receivedCode[6];
if (P1) errorPosition += 1;
if (P2) errorPosition += 2;
if (P4) errorPosition += 4;
return errorPosition;
}
int main() {
int dataBits[4];
int hammingCode[7];
int receivedCode[7];
int i;
printf("Enter 4-bit data (e.g., 1010): ");
for ( i = 0; i < 4; i++) {
scanf("%d", &dataBits[i]);
}
calculateHammingCode(dataBits, hammingCode);
printf("7-bit Hamming Code: ");
for ( i = 0; i < 7; i++) {
printf("%d", hammingCode[i]);
}
printf("\n");
printf("Enter received 7-bit Hamming Code: ");
for ( i = 0; i < 7; i++) {
scanf("%d", &receivedCode[i]);
}
int errorPosition = detectError(receivedCode);
if (errorPosition == 0) {
printf("No error detected in the received Hamming code.\n");
} else {
printf("Error detected at bit position %d.\n", errorPosition);
printf("Correcting the error...\n");
receivedCode[errorPosition - 1] = !receivedCode[errorPosition - 1];
printf("Corrected 7-bit Hamming Code: ");
for (i = 0; i < 7; i++) {
printf("%d", receivedCode[i]);
}
printf("\n");

}
return 0;
}
