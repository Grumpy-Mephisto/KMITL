#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>
#include <stdlib.h>

#define NITER 100000 // 100 x 1,000

pthread_attr_t attr[2];
pthread_t tid[2];
sem_t mySemaphore;
int cnt;

void *Count(void *a) {
  int i;
  for (i = 0; i < NITER; i++) {
    /**
     * C
     */
    sem_wait(&mySemaphore);
    cnt++;
    sem_post(&mySemaphore);
  }
  void *lastSeen = malloc(sizeof(int));
  if (pthread_self() == tid[0]) {
    *(int *)lastSeen = cnt;
    printf("Thread %lu exits. Last seen is %d\n", pthread_self(), cnt);
    pthread_exit((void *)lastSeen);
  }
}
int main() {
  /**
   * D
   */
  sem_init(&mySemaphore, 0, 1);
  pthread_attr_init(&attr[0]);
  pthread_attr_init(&attr[1]);
  pthread_create(&tid[0], &attr[0], Count, NULL);
  pthread_create(&tid[1], &attr[1], Count, NULL);
  void *returnVal;
  pthread_join(tid[0], &returnVal);
  int x = *(int *)returnVal;
  printf("Last count from tid[0] is %d\n", x);

  pthread_join(tid[1], NULL);

  printf("Final count from tid[1] is %d\n", cnt);
  sem_destroy(&mySemaphore);
  return 0;
}