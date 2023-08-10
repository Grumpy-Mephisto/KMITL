#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#define clear_buffer() while (getchar() != '\n') // clear input buffer

int main(void) {
  pid_t pid[3], w;
  int num, i, status;
  int sum = 0;

  printf("Enter a positive number: ");
  num = getchar() - 48; // -48 to convert from ASCII to int
  clear_buffer();

  for (i = 0; i < 3; i++) {
    if (pid[i] = fork() == 0) {
      printf("I'm child %d, my copy of num is %d\n", i,
             num); // print the child's copy of num
      _exit(i);
    }
  }

  for (i = 0; (w = waitpid(pid[i], &status, 0)) && w != -1;
       ++i) { // wait for all children to finish
    printf("Wait on PID: %d returns value of: %d\n", w,
           WEXITSTATUS(status)); // print the exit status of each child
  }

  return 0;
}