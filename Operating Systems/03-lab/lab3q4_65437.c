#include <stdio.h>

int main() {
  int summarize = 0;
  int count = 0;
  double average = 0.0;
  int input = 0;
  int true = 1;

  while (true) {
    printf("Enter a number (or 0 to exit): ");
    scanf("%d", &input);

    if (input <= 0) break;

    summarize += input;
    count++;

    if (input > 0) average = (double)summarize / count; 
  }

  printf("summarize: %d\n", summarize);
  printf("Average: %.2f\n", average);

  return 0;
}

