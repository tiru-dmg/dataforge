#include <stdio.h>
#include <string.h>
int main() {
    char str[] = "Hello World";
    for (int i = 0; i < strlen(str); i++) {
        printf("%c", str[i] ^ 0);
    }
    printf("\n");
    return 0;
}
