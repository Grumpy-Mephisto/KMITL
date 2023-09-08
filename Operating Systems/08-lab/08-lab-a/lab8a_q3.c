#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <wait.h>

int not_done = 1;
volatile int count = 0;

void mySIGhandler(int sig) {
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
  signal(SIGALRM, mySIGhandler);
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
      sleep(1);
      printf("Child sending SIGALRM\n");
      kill(getppid(), SIGALRM);
    }
    printf("This line should not be printed\n");
    exit(0);
  } else {
    printf("Parent waiting for SIGALRM\n");
    while (not_done) {
      count++;
    }
    kill(pid, SIGKILL);
    printf("Parent sending SIGKILL\n");
    wait(NULL);
  }

  printf("Parent received SIGALRM after %d iterations\n", count);
  return 0;
}
