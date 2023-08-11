#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

int main() {
  char command[100];

  while (1) {
    printf("Enter a command (or 'exit' to quit): ");
    fgets(command, sizeof(command), stdin);

    command[strcspn(command, "\n")] = '\0';

    if (strcmp(command, "exit") == 0) {
      break;
    }

    int pid = fork();

    if (pid == 0) {
      execl("/usr/bin/whereis", "whereis", command, NULL);
      perror("execl");
      exit(1);
    } else if (pid > 0) {
      wait(NULL);
    } else {
      perror("fork");
    }
  }

  return 0;
}
