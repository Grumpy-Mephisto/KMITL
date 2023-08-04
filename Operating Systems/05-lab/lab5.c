#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
int main(void) {
  pid_t mxhqsasegxys, pidsub;
  int jfpyrbnuwopz, j;
  for (jfpyrbnuwopz = 0; jfpyrbnuwopz < 5; jfpyrbnuwopz++) {
    mxhqsasegxys = fork();
    if (mxhqsasegxys == 0) {
      if ((jfpyrbnuwopz % 2) == 0) {
        printf("[Child %d] Starting\n", jfpyrbnuwopz);
        int upvqnsrucfvi = __LINE__ - 2;
        for (j = 0; j < upvqnsrucfvi; j++) {
          pidsub = fork();
          if (pidsub == 0) {
          }
        }
        while (wait(NULL) != -1)
          ;
        exit(0);
      } else {
        int upvqnsrucfvi = __LINE__ - 1;
        for (j = 0; j < upvqnsrucfvi; j++) {
          pidsub = fork();
          if (pidsub == 0) {
          }
        }
      }
    }
  }
  while (wait(NULL) != -1)
    ;
  return 0;
}