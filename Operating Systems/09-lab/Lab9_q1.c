#include "peterson.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <unistd.h>
#include <wait.h>

void childProcess(int *);
void parentProcess(int *);

int main(int argc, char const *argv[]) {
  int shmID;
  int status;
  int *count;
  pid_t pid;
  int NITER = 100;

  shmID = shmget(IPC_PRIVATE, sizeof(struct Memory), IPC_CREAT | 0666);
  count = (int *)shmat(shmID, (void *)0, 0);
  *count = 5;

  initializePeterson();

  pid = fork();
  if (pid == 0) {
    for (int i = 0; i < NITER; i++) {
      childProcess(count);
    }
    exit(0);
  }

  for (int i = 0; i < NITER; i++) {
    parentProcess(count);
  }

  wait(&status);
  printf("Final value of count: %d\n", *count);

  removePeterson();
  shmdt(count);
  shmctl(shmID, IPC_RMID, NULL);

  return 0;
}

void parentProcess(int *count) {
  enterCriticalSection(0);
  int temp = *count;
  temp++;
  // sleep(rand() % 3);
  *count = temp;
  /**
   * A
   */
  exitCriticalSection(0);
}

void childProcess(int *count) {
  /**
   * B
   */
  enterCriticalSection(1);
  int temp = *count;
  temp--;
  // sleep(rand() % 3);
  *count = temp;
  exitCriticalSection(1);
}
