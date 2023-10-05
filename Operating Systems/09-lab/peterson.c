#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

#include "peterson.h"

static struct Memory *ptr;
static int shmID = 0;

void initializePeterson() {
  shmID = shmget(IPC_PRIVATE, sizeof(struct Memory), IPC_CREAT | 0666);
  if (shmID < 0) {
    printf("*** shmget error (server) ***\n");
    exit(1);
  }

  ptr = (struct Memory *)shmat(shmID, NULL, 0);
  if (ptr == NULL) {
    printf("*** shmat error (server) ***\n");
    exit(1);
  }
  // initialize
  ptr->turn = 0;
  ptr->flag[0] = FALSE;
  ptr->flag[1] = FALSE;
}
void removePeterson() {
  shmdt((void *)ptr);
  shmctl(shmID, IPC_RMID, NULL);
}
void enterCriticalSection(int process) {
  int j = 0;
  if (process == 0) {
    j = 1;
  } else {
    j = 0;
  }
  ptr->turn = j;             // work if and only if this statement is atomic
  ptr->flag[process] = TRUE; // work if and only if this statement is atomic
  while (ptr->flag[j] && ptr->turn == j)
    ;
}

int exitCriticalSection(int process) {
  ptr->flag[process] = FALSE; // work if and only it this statement is atomic
}
