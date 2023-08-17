#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int sum;
void *runner(void *param);

int main(int argc, char *argv[]) {
  pthread_t tid;
  pthread_attr_t attr;
  pthread_attr_init(&attr);

  pthread_create(&tid, &attr, runner, argv[1]); // create thread
  pthread_join(tid, NULL);                      // wait for thread to finish
  printf("Summation is %d\n", sum);
  return 0;
}

void *runner(void *param) {
  int upper = atoi(param);
  int i;
  sum = 0;

  if (upper > 0) {
    for (i = 0; i <= upper; i++) {
      sum += i;
    }
  }
  pthread_exit(0);
}