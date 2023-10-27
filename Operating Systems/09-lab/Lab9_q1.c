#include "peterson.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <unistd.h>
#include <wait.h>

void childProcess(int *);
void parentProcess(int *);

int main(int argc, char const *argv[]) {
  int shmID;
  int status;
  int *count;
  pid_t pid;
  int NITER = 100;

  shmID = shmget(
      IPC_PRIVATE, sizeof(struct Memory),
      IPC_CREAT |
          0666); // shmID คือ ตัวแปรที่เก็บค่า id ของ shared memory โดยจะเก็บค่า id
                 // นี้ไว้เพื่อเอาไปใช้ในการระบุว่าเราจะเข้าถึง shared memory ตัวไหน
  count = (int *)shmat(shmID, (void *)0, 0); // ทำการ attach ตัวแปร count กับ
                                             // shared memory ที่มี id เท่ากับ
                                             // shmID ที่สร้างขึ้น
  *count = 5;

  initializePeterson(); // สร้าง lock ขึ้นมา

  pid = fork(); // สร้าง child process
  if (pid == 0) {
    for (int i = 0; i < NITER; i++) {
      childProcess(count); // ทำงานใน critical section
    }
    exit(0);
  }

  for (int i = 0; i < NITER; i++) {
    parentProcess(count); // ทำงานใน critical section
  }

  wait(&status); // รอให้ child process ทำงานเสร็จ โดยการรอค่า status จาก child
                 // process ที่ส่งมา
  printf("Final value of count: %d\n", *count);

  removePeterson(); // ลบ lock ที่สร้างขึ้นมา
  shmdt(count); // ทำการ detach ตัวแปร count จาก shared memory
  shmctl(shmID, IPC_RMID, NULL); // ทำการลบ shared memory ที่มี id เท่ากับ
                                 // shmID ที่สร้างขึ้นมา

  return 0;
}

void parentProcess(int *count) { // ทำงานใน critical section
  enterCriticalSection(0); // ทำการ enter critical section โดยใช้ lock ที่มี
                           // index เท่ากับ 0
  int temp = *count;
  temp++;
  // sleep(rand() % 3);
  *count = temp;
  /**
   * A
   */
  exitCriticalSection(0); // ทำการ exit critical section โดยใช้ lock ที่มี index
                          // เท่ากับ 0
}

void childProcess(int *count) {
  /**
   * B
   */
  enterCriticalSection(1); // ทำการ enter critical section โดยใช้ lock ที่มี
                           // index เท่ากับ 1
  int temp = *count;
  temp--;
  // sleep(rand() % 3);
  *count = temp;
  exitCriticalSection(1); // ทำการ exit critical section โดยใช้ lock ที่มี index
                          // เท่ากับ 1
}
