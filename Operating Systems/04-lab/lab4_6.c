#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main() {
  pid_t pid;
  int i = 0;
  int num = 0;
  int sum = 0;

  printf("Enter a positive number: ");
  scanf("%d", &num);

  if (num < 0) {
    printf("Invalid input\n");
    exit(1);
  }

  if ((pid = fork()) > 0) {
    for (i = 1; i <= num; i++) {
      sum += i;
    }
  } else {
    for (i = 1; i <= 2; i++) {
      sum += i;
    }
    printf("[Child] Sum is %d\n", sum);
    exit(0);
  }

  wait(NULL);
  printf("[Parent] Sum is %d\n", sum);

  return 0;
}