#include <stdio.h>
#include <string.h>
int main() {
    char str[] = "Hello World", str1[11], str2[11];
    int i, len = strlen(str);
    for (i = 0; i < len; i++) str1[i] = str[i] & 127, printf("%c", str1[i]);
    printf("\n");
    for (i = 0; i < len; i++) str2[i] = str[i] ^ 127, printf("%c", str2[i]);
    printf("\n");
    return 0;
}
