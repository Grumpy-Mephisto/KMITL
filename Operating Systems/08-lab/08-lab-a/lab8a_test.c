#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

/**
 * Signal handler for SIGINT
 * @param sig signal number
 * @return void
 * @brief This function is called when SIGINT is received
 * @note This function is called when SIGINT is received
 */
void INThandler(int);

int main(int argc, char const *argv[]) {
  signal(SIGINT, INThandler);

  while (1) {
    // CPU can be allocated to other processes
    printf("Press Ctrl-C to exit\n");
    pause();
  }

  return 0;
}

void INThandler(int sig) {
  signal(sig, SIG_IGN);
  printf("\nCtrl-C pressed\nWould you like to exit? [y/n] ");

  char c;
  scanf("%c", &c);
  if (c == 'y' || c == 'Y') {
    exit(0);
  } else {
    signal(SIGINT, INThandler);
  }
}
