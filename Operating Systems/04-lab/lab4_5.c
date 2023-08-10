#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int sum = 0;

int main(void) {
  pid_t pid;
  int i;

  if ((pid = fork()) > 0) {
    i = 1;
    sum += i;
    printf("[Parent] My id is %d\n", getpid());
    printf("[Parent] Sum after parent's update: %d\n", sum);
  } else {
    i = 2;
    sum += i;
    printf("[Child] My id is %d\n", getpid());
    printf("[Child] My parent's id is %d\n", getppid());
    printf("[Child] Sum after child's update: %d\n", sum);
    exit(0);
  }

  wait(NULL);
  printf("[Parent] Sum is %d\n", sum);
  return 0;
}