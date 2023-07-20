#include <stdio.h>

int main() {
  int summarize = 0;
  int count = 0;
  double average = 0.0;
  int input = 0;

  printf("Enter a number: ");
  scanf("%d", &input);

  while (input > 0) {
    summarize += input;
    count++;

    if (input > 0) {
      average = (double)summarize / count; 
    }

    printf("Enter another number (or 0 to exit): ");
    scanf("%d", &input);
  }

  printf("Sum: %d\n", summarize);
  printf("Average: %.2f\n", average);

  return 0;
}

