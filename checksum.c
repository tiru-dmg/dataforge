#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void get_complement(char* binary) {
    int i;
	for ( i = 0; binary[i] != '\0'; i++) {
        binary[i] = (binary[i] == '0') ? '1' : '0';}}
int main() {
    char binary[256], chunk[256];
    int i, chunks, sum = 0;
    printf("Enter binary string: ");
    scanf("%s", binary);
    printf("Enter number of chunks: ");
    scanf("%d", &chunks);
    int chunk_len = strlen(binary) / chunks;
    printf("Chunks: ");
    for ( i = 0; i < chunks; i++) {
        strncpy(chunk, &binary[i * chunk_len], chunk_len);
        chunk[chunk_len] = '\0';
        printf("%s ", chunk);
        sum += strtol(chunk, NULL, 2); }
    printf("\n");
    char sum_bin[256];
    itoa(sum, sum_bin, 2);
    printf("Sum of chunks: %s\n", sum_bin);
    char checksum[256];
    strcpy(checksum, sum_bin);
    get_complement(checksum);
    printf("Checksum: %s\n", checksum);
    int valid = (strtol(sum_bin, NULL, 2) + strtol(checksum, NULL, 2) == (1 << strlen(sum_bin)) - 1);
    printf("Checksum valid: %s\n", valid ? "true" : "false");
    return 0;
}
