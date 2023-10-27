#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>
#include <wait.h>

int main(int argc, char const *argv[]) {
  int *count;
  int shmid;
  /**
   * Q5.1 a or b?
   * a. shmid = shmget(key, sizeof(int), IPC_CREAT | 0666);
   * b. shmid = shmget(key, sizeof(int), 0666);
   * Answer: a
   */
  shmid = shmget(IPC_PRIVATE, sizeof(int), IPC_CREAT | 0666); // สร้าง shared
                                                              // memory โดยใช้
                                                              // shmget()
                                                              // โดยกำหนดขนาด
                                                              // 1024 bytes
                                                              // และสร้าง
                                                              // shared memory
                                                              // ใหม่ หากยังไม่มี
                                                              // shared memory นี้

  /**
   * Q5.2
   * Answer: (int *)
   */
  count = (int *)shmat(shmid, NULL, 0); // ทำการ attach ไปยัง shared memory
                                        // โดยใช้ shmat() โดยกำหนดให้ str เป็น
                                        // pointer ชี้ไปยัง shared memory

  count[0] = 5;

  pid_t pid; // สร้าง process ใหม่
  if ((pid = fork()) == 0) {
    int temp = count[0];
    sleep(1);
    temp--;
    /**
     * Q5.3
     * Answer: count[0] = temp;
     */
    count[0] = temp;
    printf("Child decrement value at %p (%d)\n", &count, count[0]);
    exit(0);
  }
  /**
   * Q5.4 Cannot use wait(NULL), what's output on final value?
   * Answer: 4
   */
  // wait(NULL);
  int temp = count[0];
  sleep(1);
  temp++;
  count[0] = temp;
  printf("Parent increment value at %p (%d)\n", &count, count[0]);
  sleep(1);
  printf("Final value: %d\n", count[0]);

  shmdt(count); // ทำการ detach จาก shared memory โดยใช้ shmdt()
  shmctl(shmid, IPC_RMID, NULL); // ทำการลบ shared memory โดยใช้ shmctl()

  return 0;
}
