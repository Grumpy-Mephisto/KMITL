#include <stdio.h>

void multiple_matrix(int a[3][3], int b[3][3], int result[3][3]) {
  for (int i = 0; i < 3; i++)
    for (int j = 0; j < 3; j++)
      for (int k = 0; k < 3; k++)
        result[i][j] += a[i][k] * b[k][j];
}

void print_matrix(const char *equation, int matrix[3][3]) {
  printf("Matrix %s\n", equation);
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++)
      printf("%4d ", matrix[i][j]);
    printf("\n");
  }
}

int main(void) {
  int a[3][3] = {{2, 3, 4}, {3, 4, 5}, {1, 3, 3}};
  int b[3][3] = {{3, 4, 1}, {7, 2, 4}, {3, 8, 6}};
  int result[3][3] = {0};

  print_matrix("A ", a);
  print_matrix("B ", b);
  multiple_matrix(a, b, result);
  print_matrix("A x B ", result);
  multiple_matrix(b, a, result);
  print_matrix("B x A ", result);

  return 0;
}
