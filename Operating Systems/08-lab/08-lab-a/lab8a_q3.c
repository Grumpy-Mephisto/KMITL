#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <wait.h>

int not_done = 1;
volatile int count = 0;

void mySIGALRMhandler(int sig) {
  signal(SIGALRM, SIG_IGN);
  not_done = 0;
  printf("SIGALRM received\n");
}

void mySIGKILLhandler(int sig) {
  signal(SIGKILL, SIG_IGN);
  not_done = 0;
  printf("SIGKILL received\n");
}

int main(int argc, char const *argv[]) {
  // signal(SIGALRM, mySIGALRMhandler);
  signal(SIGKILL, mySIGKILLhandler);
  pid_t pid = fork();

  // if (pid == 0) {
  //   sleep(4);
  //   printf("Child sending SIGALRM\n");
  //   kill(getppid(), SIGALRM);
  //   exit(0);
  // } else {
  //   printf("Parent waiting for SIGALRM\n");
  //   while (not_done) {
  //     count++;
  //   }
  // }
  if (pid == 0) {
    printf("Child created\n");
    while (1) {
      printf("Child waiting for SIGKILL\n");
      while (not_done) {
        count++;
      }
    }
    printf("This line should not be printed\n");
    exit(0);
  } else {
    sleep(4);
    printf("Parent sending SIGKILL\n");
    kill(pid, SIGKILL);
    wait(NULL);
  }

  printf("Parent received SIGKILL after %d iterations\n", count);
  // printf("Parent received SIGALRM after %d iterations\n", count);
  return 0;
}
