#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void get_complement(const char* binary, char* complement) {
    for (int i = 0; binary[i] != '\0'; i++) {
        complement[i] = (binary[i] == '0') ? '1' : '0';
    }
    complement[strlen(binary)] = '\0'; // Null-terminate the complement string
}

int main() {
    char buff[256]; // Buffer for binary input
    int num_of_chunks;

    // Input binary string
    printf("Enter binary string: ");
    scanf("%s", buff);

    // Input number of chunks
    printf("Enter number of chunks: ");
    scanf("%d", &num_of_chunks);

    int chunks_length = strlen(buff) / num_of_chunks; // Calculate the length of each chunk
    int sum = 0; // Variable to store the sum of chunks

    printf("Chunks: ");
    for (int i = 0; i < num_of_chunks; i++) {
        // Extract chunk
        char chunk[256];
        strncpy(chunk, &buff[i * chunks_length], chunks_length);
        chunk[chunks_length] = '\0'; // Null-terminate the chunk
        printf("%s ", chunk);

        // Convert chunk to decimal and add to sum
        sum += (int)strtol(chunk, NULL, 2);
    }
    printf("\n");

    // Convert the sum to binary representation
    char sum_binary[256];
    itoa(sum, sum_binary, 2); // Convert sum to binary string

    printf("Sum of chunks: %s\n", sum_binary);

    // Calculate the complement
    char complement[256];
    get_complement(sum_binary, complement);
    printf("Checksum: %s\n", complement);

    // Sum of chunks and its complement
    int final_sum = sum + (int)strtol(complement, NULL, 2);
    char final_sum_binary[256];
    itoa(final_sum, final_sum_binary, 2); // Convert final sum to binary string
    printf("Sum of chunks and checksum: %s\n", final_sum_binary);

    // Verify checksum
    char final_sum_complement[256];
    get_complement(final_sum_binary, final_sum_complement);
    int checksum_valid = (atoi(final_sum_complement) == 0);
    printf("Checksum valid: %s\n", checksum_valid ? "true" : "false");

    return 0;
}
