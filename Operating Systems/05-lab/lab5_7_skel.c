#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main(void) {
  pid_t pid, pidsub;
  int i, j;

  printf("Only parent process before fork\n");
  for (i = 0; i < 5; i++) {
    pid = fork();
    // wait(NULL); // wait for child to terminate
    if (pid == 0) {
      if ((i % 2) == 0) {
        printf("[Child %d] Starting\n", i);
        int num_gc = 3; // 7.1
        for (j = 0; j < num_gc; j++) {
          pidsub = fork(); // 7.2
          if (pidsub == 0) {
            printf("[Grandchild %d of even Child %d] Running\n", j, i);
            exit(0); // 7.3
          }
        }
        while (wait(NULL) != -1)
          ; // 7.4
        exit(0);
      } else {
        printf("[Child %d] Starting\n", i);
        int num_gc = 4; // 7.5
        for (j = 0; j < num_gc; j++) {
          pidsub = fork();
          if (pidsub == 0) { // 7.6
            printf("[Grandchild %d of even Child %d] Running\n", j, i);
            exit(0); // 7.7
          }
        }
        while (wait(NULL) != -1)
          ;
        exit(0); // 7.8
      }
    }
    // exit(0); // 7.9: Unnecessary exit(0) because have exit(0) in child
  }

  while (wait(NULL) != -1)
    ;

  printf("[Parent] All children terminated. Exiting...\n");
  return 0;
}
