#include <stdio.h>

void main() {
    unsigned int compad[4];
    unsigned int mask[4];
    unsigned int netadr[4];
    int i;

    printf("Enter the IP address (format: x.x.x.x):\n");
    scanf("%u.%u.%u.%u", &compad[3], &compad[2], &compad[1], &compad[0]);

    printf("Enter the Subnet Mask (format: x.x.x.x):\n");
    scanf("%u.%u.%u.%u", &mask[3], &mask[2], &mask[1], &mask[0]);

    // Calculate network address
    for (i = 0; i < 4; i++) {
        netadr[i] = compad[i] & mask[i];
    }

    printf("\nNetwork Address: %u.%u.%u.%u\n", netadr[3], netadr[2], netadr[1], netadr[0]);
    printf("Subnet Mask: %u.%u.%u.%u\n", mask[3], mask[2], mask[1], mask[0]);
    printf("IP Address: %u.%u.%u.%u\n", compad[3], compad[2], compad[1], compad[0]);
}
