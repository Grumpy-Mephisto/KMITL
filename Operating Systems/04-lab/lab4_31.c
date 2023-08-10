#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main(void) {
  pid_t pid;
  int i;
  int sum = 3;

  pid = fork();
  if (pid > 0) {
    i = 1;
    sum += i;
    printf("my copy of i is %d\n", i);
  } else {
    i = 2;
    sum += i;
    printf("my copy of i is %d\n", i);
  }

  printf("sum is %d\n", sum);
  wait(NULL);
  return 0;
}
