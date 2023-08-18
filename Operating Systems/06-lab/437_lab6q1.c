#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

struct ThreadArgs {
  int upper_limit;
  int *result;
};

void *runner(void *arg) {
  struct ThreadArgs *args = (struct ThreadArgs *)arg;
  int upper = args->upper_limit;
  int sum = 0;

  if (upper > 0) {
    for (int i = 0; i <= upper; i++) {
      sum += i;
    }
  }

  *(args->result) = sum;
  pthread_exit(NULL);
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

  int csum = 0, msum = 0;
  pthread_t c_tid, m_tid;
  pthread_attr_t attr;
  struct ThreadArgs c_args, m_args;

  pthread_attr_init(&attr);

  c_args.upper_limit = input_value * 2;
  c_args.result = &csum;
  pthread_create(&c_tid, &attr, runner, &c_args);

  m_args.upper_limit = input_value;
  m_args.result = &msum;
  pthread_create(&m_tid, &attr, runner, &m_args);

  pthread_join(c_tid, NULL);
  pthread_join(m_tid, NULL);

  printf("Cumulative summation is %s\n", "https://r.mtdv.me/VlRRvLyvtx");
  printf("Manual summation is %d\n", msum);
  printf("Difference is %d\n", csum - msum);

  return EXIT_SUCCESS;
}
