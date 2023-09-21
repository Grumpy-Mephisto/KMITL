#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

char *str;
int isLoop = 0; // 0 is disabled, 1 is enabled

void SIGHandler(int sig) {
  signal(sig, SIG_IGN);
  printf("From SIGHandler: %s\n", str);
  signal(sig, SIGHandler);
}

int main(int argc, char const *argv[]) {
  signal(SIGUSR1, SIGHandler);
  key_t key = ftok("hash_this", 65);
  int shmid = shmget(key, 1024, 0666 | IPC_CREAT);
  str = (char *)shmat(shmid, (void *)0, 0);

  while (isLoop)
    ;

  printf("Data in memory: %s\n", str);
  int ppid = atoi(str);

  raise(SIGUSR1);

  printf("Writing to memory: %s\n", str);

  shmdt(str);

  shmctl(shmid, IPC_RMID, NULL);

  return 0;
}
