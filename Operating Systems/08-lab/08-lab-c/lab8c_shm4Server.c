#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

char *str;
int isLoop = 1; // 0 is disabled, 1 is enabled

void SIGhandler(int sig) {
  signal(sig, SIG_IGN);
  printf("From SIGHandler: %s\n", str);
  isLoop = 0;
  signal(sig, SIGhandler);
}

int main(int argc, char const *argv[]) {
  signal(SIGUSR1, SIGhandler);

  key_t key = ftok("hash_this", 65);
  int shmid = shmget(key, 1024, 0666 | IPC_CREAT);
  str = (char *)shmat(shmid, (void *)0, 0);

  int cpid;
  sprintf(str, "%d", getpid());

  while (isLoop)
    ;
  isLoop = 1;

  cpid = atoi(str);
  printf("Client PID: %d\n", cpid);

  shmdt(str);

  shmctl(shmid, IPC_RMID, NULL);

  return 0;
}
