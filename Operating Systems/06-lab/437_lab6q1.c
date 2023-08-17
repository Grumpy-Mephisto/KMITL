#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>

#define EXIT_FAILURE 1

struct ThreadArgs {
  int upper_limit;
  int result;
};

void calculate_sum(struct ThreadArgs *args) {
  int upper = args->upper_limit;
  int sum = 0;

  if (upper > 0) {
    for (int i = 0; i <= upper; i++) {
      sum += i;
    }
  }

  args->result = sum;
}

int main(int argc, char *argv[]) {
  if (argc != 2) {
    fprintf(stderr, "usage: %s <integer value>\n", argv[0]);
    return EXIT_FAILURE;
  }

  int input_value = atoi(argv[1]);
  if (input_value < 0) {
    fprintf(stderr, "%d must be >= 0\n", input_value);
    return EXIT_FAILURE;
  }

  int pipe_fd[2];
  if (pipe(pipe_fd) == -1) {
    perror("Pipe creation failed");
    return EXIT_FAILURE;
  }

  pid_t pid;
  struct ThreadArgs child_args, parent_args;

  child_args.upper_limit = 2 * input_value;

  pid = fork();
  if (pid < 0) {
    perror("Fork failed");
    return EXIT_FAILURE;
  } else if (pid == 0) {
    // Child process
    close(pipe_fd[0]); // Close read end

    calculate_sum(&child_args);
    write(pipe_fd[1], &child_args.result, sizeof(int));

    close(pipe_fd[1]);
    exit(EXIT_SUCCESS);
  } else {
    // Parent process
    close(pipe_fd[1]); // Close write end

    parent_args.upper_limit = input_value;
    calculate_sum(&parent_args);

    int child_sum;
    read(pipe_fd[0], &child_sum, sizeof(int));
    close(pipe_fd[0]);

    wait(NULL);

    printf("Child: Summation is %d\n", child_sum);
    printf("Parent: Summation is %d\n", parent_args.result);
    printf("Difference is %d\n", child_sum - parent_args.result);
  }

  return EXIT_SUCCESS;
}
