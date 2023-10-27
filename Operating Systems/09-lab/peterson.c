#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

#include "peterson.h"

static struct Memory *ptr;
static int shmID = 0;

void initializePeterson() {
  shmID =
      shmget(IPC_PRIVATE, sizeof(struct Memory), IPC_CREAT | 0666); // สร้าง
                                                                    // shared
                                                                    // memory
                                                                    // ขึ้นมา
  if (shmID < 0) {
    printf("*** shmget error (server) ***\n");
    exit(1);
  }

  ptr = (struct Memory *)shmat(shmID, NULL, 0); // ทำการ attach ตัวแปร ptr
                                                // กับ shared memory ที่มี id
                                                // เท่ากับ shmID ที่สร้างขึ้นมา
  if (ptr == NULL) {
    printf("*** shmat error (server) ***\n");
    exit(1);
  }
  // initialize
  ptr->turn = 0; // ทำการ initialize ค่า turn ให้เท่ากับ 0
  ptr->flag[0] = FALSE; // ทำการ initialize ค่า flag ให้เท่ากับ FALSE
  ptr->flag[1] = FALSE; // ทำการ initialize ค่า flag ให้เท่ากับ FALSE
}
void removePeterson() {
  shmdt((void *)ptr); // ทำการ detach ตัวแปร ptr จาก shared memory
  shmctl(shmID, IPC_RMID, NULL); // ทำการลบ shared memory ที่มี id เท่ากับ
                                 // shmID ที่สร้างขึ้นมา
}
void enterCriticalSection(int process) {
  int j = 0;
  if (process == 0) {
    j = 1;
  } else {
    j = 0;
  }
  ptr->turn = j; // สลับค่า turn ให้เป็น j
  ptr->flag[process] = TRUE; // วาง flag ของ process ที่เข้ามาใช้งานใน critical
                             // section ให้เป็น TRUE
  while (ptr->flag[j] && ptr->turn == j) // ถ้า flag ของ process ที่ไม่ได้เข้า
                                         // มาใช้งานใน critical section ยังเป็น
                                         // TRUE และ turn ยังเป็น j
    ;
}

int exitCriticalSection(int process) {
  ptr->flag[process] = FALSE; // ทำการเปลี่ยน flag ของ process ที่เข้ามาใช้งาน
                              // critical section ให้เป็น FALSE
}
