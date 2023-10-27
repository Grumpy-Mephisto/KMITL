#include <stdio.h>
#include <sys/ipc.h>
#include <sys/shm.h>

int main(int argc, char const *argv[]) {
  key_t key = ftok("shmfile", 65); // สร้าง key จากชื่อไฟล์ shmfile โดยใช้ ftok()
                                   // โดย key จะถูกสร้างจาก inode และ minor number
                                   // ของไฟล์ shmfile โดยใช้ ftok()
                                   // โดย key จะถูกสร้างจาก inode และ minor number
                                   // ของไฟล์ shmfile

  // shmget returns an identifier in shmid
  int shmid = shmget(key, 1024, 0666 | IPC_CREAT); // สร้าง shared memory โดยใช้
                                                   // shmget() โดยกำหนดขนาด 1024
                                                   // bytes และสร้าง shared
                                                   // memory ใหม่ หากยังไม่มี shared
                                                   // memory นี้ โดยใช้ shmget()
                                                   // โดยกำหนดขนาด 1024 bytes
                                                   // และสร้าง shared memory ใหม่
                                                   // หากยังไม่มี shared memory นี้

  // shmat to attach to shared memory
  char *str = (char *)shmat(shmid, (void *)0, 0); // ทำการ attach ไปยัง shared
                                                  // memory โดยใช้ shmat() โดย
                                                  // กำหนดให้ str เป็น pointer
                                                  // ชี้ไปยัง shared memory
                                                  // โดยใช้ shmat() โดยกำหนดให้
                                                  // str เป็น pointer ชี้ไปยัง
                                                  // shared memory

  printf("Read from memory: %s\n", str);

  // sprintf(str, "Hello World")
  printf("Data written in memory: %s\n", str);

  // detach from shared memory
  shmdt(str); // ทำการ detach จาก shared memory โดยใช้ shmdt()

  // destroy the shared memory
  shmctl(shmid, IPC_RMID, NULL); // ทำการลบ shared memory โดยใช้ shmctl()

  return 0;
}
