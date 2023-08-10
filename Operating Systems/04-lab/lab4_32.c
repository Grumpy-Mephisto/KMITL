#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main(void) {
  pid_t pid;
  int i;
  int sum = 3;

  for (i = 0; i < 3; i++) {
    pid = fork();
    if (pid == 0) {
      printf("my copy of i is %d\n", i);
      exit(0);
      printf("should not be executed\n");
    }
  }

  while (wait(NULL) != -1)
    ;
  printf("Bye from main\n");
  return 0;
}