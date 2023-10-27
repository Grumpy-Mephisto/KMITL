#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

char *str;
int isLoop1 = 1; // 0 is disabled, 1 is enabled

void SIGHandler1(int sig) { // รับ signal ที่รับเข้ามา
  signal(sig, SIG_IGN); // ไม่สนใจ signal ที่รับเข้ามา
  sleep(1);
  printf("PPID: %s, Btw SIGUSR1: %d\n", str, sig);
  isLoop1 = 0;
  signal(sig, SIGHandler1); // รับ signal ที่รับเข้ามา
}

int main(int argc, char const *argv[]) {
  signal(SIGUSR1, SIGHandler1); // ทำการ register การรับสัญญาณ SIGUSR1

  key_t key = ftok("hash_this", 65); // สร้าง key จากชื่อไฟล์ hash_this โดยใช้
                                     // ftok() โดย key จะถูกสร้างจาก inode และ
                                     // minor number ของไฟล์ hash_this
  int shmid = shmget(key, 1024, 0666); // สร้าง shared memory โดยใช้ shmget()
                                       // โดยกำหนดขนาด 1024 bytes และสร้าง
                                       // shared memory ใหม่ หากยังไม่มี shared
                                       // memory นี้
  str = (char *)shmat(shmid, (void *)0, 0); // ทำการ attach ไปยัง shared memory
                                            // โดยใช้ shmat() โดยกำหนดให้ str
                                            // เป็น pointer ชี้ไปยัง shared
                                            // memory

  int ppid = atoi(str); // แปลง string ที่อยู่ใน shared memory ให้เป็น integer
  sprintf(str, "%d", getpid());
  printf("Successfully obtained PPID: %d\n", ppid);

  kill(ppid, SIGUSR1); // ส่ง SIGUSR1 ไปยัง process ที่มี pid เป็น ppid โดยใช้
                       // kill()

  while (isLoop1)
    ;
  sleep(1);
  printf("Waiting for SIG before writing to server\n");

  sprintf(str, "%s", "os kmitl\n");
  printf("Client write to memory & notify: %s\n", str);
  kill(ppid, SIGUSR1); // ส่ง SIGUSR1 ไปยัง process ที่มี pid เป็น ppid โดยใช้
                       // kill()

  shmdt(str); // ทำการ detach จาก shared memory โดยใช้ shmdt()

  return 0;
}
