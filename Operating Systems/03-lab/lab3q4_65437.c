#include <stdio.h>

int main() {
  int a, b, c;

  printf("Enter a numbers: ");
  scanf("%d", &a);

  printf("Enter two numbers: ");
  scanf("%d %d", &b, &c);

  printf("Summation = %d\n", a + b + c);

  return 0;
}
