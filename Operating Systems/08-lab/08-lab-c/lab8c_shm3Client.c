#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

char *str;
int isLoop1 = 1; // 0 is disabled, 1 is enabled

void SIGHandler1(int sig) {
  signal(sig, SIG_IGN);
  sleep(1);
  printf("PPID: %s, Btw SIGUSR1: %d\n", str, sig);
  isLoop1 = 0;
  signal(sig, SIGHandler1);
}

int main(int argc, char const *argv[]) {
  signal(SIGUSR1, SIGHandler1);

  key_t key = ftok("hash_this", 65);
  int shmid = shmget(key, 1024, 0666);
  str = (char *)shmat(shmid, (void *)0, 0);

  int ppid = atoi(str);
  sprintf(str, "%d", getpid());
  printf("Successfully obtained PPID: %d\n", ppid);

  kill(ppid, SIGUSR1);

  while (isLoop1)
    ;
  sleep(1);
  printf("Waiting for SIG before writing to server\n");

  sprintf(str, "%s", "os kmitl\n");
  printf("Client write to memory & notify: %s\n", str);
  kill(ppid, SIGUSR1);

  shmdt(str);

  return 0;
}
