#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char const *argv[]) {
  FILE *file_desc = fopen("aaa.txt", "w");
  int fd = fileno(file_desc);
  printf("Current file descriptor id is %d\n", fd);

  dup2(fd, STDOUT_FILENO);
  printf("Please read this line in aaa.txt\n");
  close(fd);
  return 0;
}
