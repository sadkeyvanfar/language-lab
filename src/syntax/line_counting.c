#include <stdio.h>

/*
 * This program counts the number of lines in the input.
 * It reads characters until it encounters an EOF (End of File).
 * Each time a newline character ('\n') is encountered, the line counter is
 * incremented. Finally, the program prints the total number of lines.
 */
int main() {
  int c, nl;
  nl = 0;
  while ((c = getchar()) != EOF)
    if (c == '\n')
      ++nl;
  printf("%d\n", nl);
  return 0;
}