#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main() {
  pid_t cpid;
  pid_t gcpid;

  cpid = fork();

  if (cpid == 0) {
    gcpid = fork();
    if (gcpid == 0) {
      printf("[Grandchild] pid: %d, ppid: %d\n", getpid(), getppid());
      exit(0);
    }
    execlp("/bin/als", "ls", NULL);                             // A
    printf("[Child] pid: %d, ppid: %d\n", getpid(), getppid()); // B
  } else {
    printf("[Parent] pid: %d, ppid: %d\n", getpid(), getppid()); // C
    wait(NULL);
    exit(0);
  }
  return 0;
}
