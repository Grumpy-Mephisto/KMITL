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
  pipe(pipefd); // สร้าง pipe และเก็บ file descriptor ไว้ใน pipefd
  printf("Write pipe id: %d\n", pipefd[1]);
  printf("Read pipe id: %d\n", pipefd[0]);

  pid = fork(); // สร้าง child process
  if (pid == 0) {
    close(pipefd[1]); // ปิด pipefd[1] เนื่องจาก child process จะอ่านข้อมูลจาก
                      // pipefd[0] เท่านั้น

    /**
     * Q1.2 buf
     */
    while ((nread = read(pipefd[0], buf, SIZE)) != 0) { // อ่านข้อมูลจาก pipefd[0]
                                                        // ไปเก็บใน buf
      if (nread > 11) {
        printf("Avoid overflow no conversation %s to int", buf);
      } else {
        printf("Child received: %s\n", buf);
        printf("Converted to int and plus 5: %d\n", atoi(buf) + 5);
      }
    }
    close(pipefd[0]); // ปิด pipefd[0] เนื่องจาก child process อ่านข้อมูลจาก
                      // pipefd[0] เสร็จแล้ว
  } else {
    close(pipefd[0]); // ปิด pipefd[0] เนื่องจาก parent process จะเขียนข้อมูลลงใน
                      // pipefd[1] เท่านั้น
    sprintf(inbuf, "%ld", 123456789012L);
    /**
     * Q1.3 pipefd[1], inbuf, strlen(inbuf) + 1
     */
    write(pipefd[1], inbuf, strlen(inbuf) + 1); // +1 for '\0' // เขียนข้อมูลจาก
                                                // inbuf ไปยัง pipefd[1]
    /**
     * Q1.4 pipefd[1]
     */
    close(pipefd[1]); // ปิด pipefd[1] เนื่องจาก parent process เขียนข้อมูลลงใน
                      // pipefd[1] เสร็จแล้ว
    /**
     * Q1.5 wait(NULL)
     */
    wait(NULL); // รอ child process ทำงานเสร็จ
  }

  return 0;
}
