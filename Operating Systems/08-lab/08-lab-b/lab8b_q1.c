#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <wait.h>

#define SIZE 10

int main(int argc, char const *argv[]) {
  int pipefd[2];
  int nread;
  int pid;
  char buf[SIZE];
  char inbuf[SIZE * 2];

  /**
   * Q1.1 pipefd
   */
  pipe(pipefd);
  printf("Write pipe id: %d\n", pipefd[1]);
  printf("Read pipe id: %d\n", pipefd[0]);

  pid = fork();
  if (pid == 0) {
    close(pipefd[1]);

    /**
     * Q1.2 buf
     */
    while ((nread = read(pipefd[0], buf, SIZE)) != 0) {
      if (nread > 11) {
        printf("Avoid overflow no conversation %s to int", buf);
      } else {
        printf("Child received: %s\n", buf);
        printf("Converted to int and plus 5: %d\n", atoi(buf) + 5);
      }
    }
    close(pipefd[0]);
  } else {
    close(pipefd[0]);
    sprintf(inbuf, "%ld", 123456789012L);
    /**
     * Q1.3 pipefd[1], inbuf, strlen(inbuf) + 1
     */
    write(pipefd[1], inbuf, strlen(inbuf) + 1); // +1 for '\0'
    /**
     * Q1.4 pipefd[1]
     */
    close(pipefd[1]);
    /**
     * Q1.5 wait(NULL)
     */
    wait(NULL);
  }

  return 0;
}
