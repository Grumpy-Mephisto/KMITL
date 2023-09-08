// Author: 65050437
// Output on line 20 (but line 13 on PDF): 2 Power 20 = 2432902008176640000

#include <signal.h>
#include <stdio.h>
#include <stdlib.h>

signed long prev_computed, i;

/**
 * Signal handler for SIGINT
 * @param sig signal number
 * @return void
 * @brief This function is called when SIGINT is received
 * @note This function is called when SIGINT is received
 */
void SIGhandler(int sig) {
  printf("\nReceived SIGINT\n");
  printf("SIGUSR1 the maximum value of signed long has been reached\n");
  printf("2 Power %ld = %ld\n", i - 1, prev_computed);
  exit(0);
}

int main(int argc, char const *argv[]) {
  signed long current_value;

  printf("2 Power n:\n");

  signal(SIGUSR1, SIGhandler);

  prev_computed = 1;
  for (i = 1;; i++) {
    current_value = prev_computed * i;
    if (current_value < prev_computed) {
      raise(SIGUSR1);
    }
    prev_computed = current_value;
  }

  return 0;
}
