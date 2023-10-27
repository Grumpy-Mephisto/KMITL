#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char const *argv[]) {
  FILE *file_desc = fopen("aaa.txt", "w"); // สร้างไฟล์ aaa.txt และเปิดใช้งาน
  int fd = fileno(file_desc); // ดึง file descriptor ของไฟล์ aaa.txt มาเก็บใน fd
  printf("Current file descriptor id is %d\n", fd);

  dup2(fd, STDOUT_FILENO); // ทำการ duplicate file descriptor ของไฟล์ aaa.txt
                           // ไปยัง STDOUT_FILENO
  printf("Please read this line in aaa.txt\n");
  close(fd); // ปิด file descriptor ของไฟล์ aaa.txt
  return 0;
}
