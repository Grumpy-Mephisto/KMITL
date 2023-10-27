#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

char *str;
int isLoop = 0; // 0 is disabled, 1 is enabled

void SIGHandler(int sig) { // รับ signal ที่รับเข้ามา
  signal(sig, SIG_IGN); // ไม่สนใจ signal ที่รับเข้ามา
  printf("From SIGHandler: %s\n", str);
  signal(sig, SIGHandler); // รับ signal ที่รับเข้ามา
}

int main(int argc, char const *argv[]) {
  signal(SIGUSR1, SIGHandler); // ทำการ register การรับสัญญาณ SIGUSR1
  key_t key = ftok("hash_this", 65); // สร้าง key จากชื่อไฟล์ hash_this โดยใช้
                                     // ftok() โดย key จะถูกสร้างจาก inode และ
                                     // minor number ของไฟล์ hash_this
  int shmid = shmget(key, 1024, 0666 | IPC_CREAT); // สร้าง shared memory โดยใช้
                                                   // shmget() โดยกำหนดขนาด 1024
                                                   // bytes และสร้าง shared
                                                   // memory ใหม่ หากยังไม่มี shared
                                                   // memory นี้
  str = (char *)shmat(shmid, (void *)0, 0); // ทำการ attach ไปยัง shared memory
                                            // โดยใช้ shmat() โดยกำหนดให้ str
                                            // เป็น pointer ชี้ไปยัง shared
                                            // memory

  while (isLoop)
    ;

  printf("Data in memory: %s\n", str);
  int ppid = atoi(str); // แปลง string ที่อยู่ใน shared memory ให้เป็น integer

  raise(SIGUSR1); // ส่ง SIGUSR1 ไปยัง process ที่มี pid เป็น ppid

  printf("Writing to memory: %s\n", str);

  shmdt(str); // ทำการ detach จาก shared memory โดยใช้ shmdt()

  shmctl(shmid, IPC_RMID, NULL); // ทำการลบ shared memory โดยใช้ shmctl()

  return 0;
}
