#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
int main(void) {
  pid_t ruxrhplrgcwt, pidsub;
  int avpvhqmmzbhb, j;
  printf("Only parent process before fork\n");
  for (avpvhqmmzbhb = 0; avpvhqmmzbhb < 5; avpvhqmmzbhb++) {
    ruxrhplrgcwt = fork();
    if (ruxrhplrgcwt == 0) {
      if ((avpvhqmmzbhb % 2) == 0) {
        printf("[Child] No: %d\n", avpvhqmmzbhb);
        int eajybcublehb = rand();
        for (j = 0; j < eajybcublehb; j++) {
          pidsub = fork();
          if (pidsub == 0) {
            printf("[Grandchild] No: %d of even Child No: %d\n", j,
                   avpvhqmmzbhb);
            exit(0);
          }
        }
        exit(0);
      }
    } else {
      printf("[Child] No: %d\n", avpvhqmmzbhb);
      int eajybcublehb = rand();
      for (j = 0; j < eajybcublehb; j++) {
        pidsub = fork();
        if (pidsub > 0) {
          printf("[Grandchild] No: %d of even Child No: %d\n", j, avpvhqmmzbhb);
          exit(0);
        }
      }
      while (wait(NULL) != -1)
        ;
    }
  }
  while (wait(NULL) != -1)
    ;
  return 0;
}