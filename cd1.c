#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>
bool isDelimiter(char ch) {
    return (strchr(" +-*/;,><=()[]{}", ch) != NULL);}
bool isOperator(char ch) {
    return (strchr("+-*/><=", ch) != NULL);}
bool validIdentifier(char* str) {
    if (isdigit(str[0]) || isDelimiter(str[0]))
        return false;
    for (int i = 0; str[i]; i++) {
        if (isDelimiter(str[i]))
            return false;  }
    return true;}
bool isKeyword(char* str) {
    return (strstr(" if else while do break continue int double float return char case sizeof long short typedef switch unsigned void static struct goto ", str) != NULL);}
bool isInteger(char* str) {
    for (int i = 0; str[i]; i++) {
        if (!isdigit(str[i]) && !(str[i] == '-' && i == 0))
            return false;}
    return true;}
bool isRealNumber(char* str) {
    bool hasDecimal = false;
    for (int i = 0; str[i]; i++) {
        if (!isdigit(str[i]) && str[i] != '.' && !(str[i] == '-' && i == 0))
            return false;
        if (str[i] == '.') hasDecimal = true;}
    return hasDecimal;}
char* subString(char* str, int left, int right) {
    int length = right - left + 1;
    char* subStr = (char*)malloc(length + 1);
    if (subStr) {
        strncpy(subStr, str + left, length);
        subStr[length] = '\0';}
    return subStr;}
void parse(char* str) {
    int left = 0, right = 0, len = strlen(str);
    while (right <= len) {
        if (!isDelimiter(str[right]) && right < len)
            right++;
        else {
            if (left != right) {
                char* subStr = subString(str, left, right - 1);
                if (isKeyword(subStr))
                    printf("'%s' IS A KEYWORD\n", subStr);
                else if (isInteger(subStr))
                    printf("'%s' IS AN INTEGER\n", subStr);
                else if (isRealNumber(subStr))
                    printf("'%s' IS A REAL NUMBER\n", subStr);
                else if (validIdentifier(subStr))
                    printf("'%s' IS A VALID IDENTIFIER\n", subStr);
                else
                    printf("'%s' IS NOT A VALID IDENTIFIER\n", subStr);
                free(subStr);
            }
            if (isOperator(str[right]))
                printf("'%c' IS AN OPERATOR\n", str[right]);
            left = ++right;}}}
int main() {
    char str[] = "int a = b + 1c;";
    parse(str);
    return 0;}
