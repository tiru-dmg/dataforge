!sudo apt-get update
!sudo apt-get install flex bison
------------------
%%file wordcount.l
%{
#include <stdio.h>
int lines = 0, words = 0, chars = 0;
%}

%%
\n      { lines++; chars++; }
[^ \t\n]+   { words++; chars += yyleng; }
.       { chars++; }
%%

int main(int argc, char **argv) {
    yylex();
    printf("Lines: %d, Words: %d, Characters: %d\n", lines, words, chars);
    return 0;
}
-------------------
!flex wordcount.l
!gcc lex.yy.c -o wordcount -lfl
-------------------
!echo "Hello world\nThis is a test" | ./wordcount
-------------------
Lines: 2, Words: 5, Characters: 22
