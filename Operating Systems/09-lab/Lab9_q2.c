#include <pthread.h>
#include <semaphore.h>
#include <stdio.h>
#include <stdlib.h>

#define NITER 100000 // 100 x 1,000

pthread_attr_t attr[2];
pthread_t tid[2];
sem_t mySemaphore;
int cnt;

void *Count(void *a) {
  int i;
  for (i = 0; i < NITER; i++) {
    /**
     * C
     */
    sem_wait(&mySemaphore); // ทำการ lock โดยการลดค่าของ semaphore ลง 1
    cnt++;
    sem_post(&mySemaphore); // ทำการ unlock โดยการเพิ่มค่าของ semaphore ขึ้น 1
  }
  void *lastSeen = malloc(sizeof(int));
  if (pthread_self() == tid[0]) { // ถ้า thread ที่ทำงานอยู่เป็น thread ที่ 0
    *(int *)lastSeen = cnt; // ให้ lastSeen เก็บค่า cnt ของ thread ที่ 0
    printf("Thread %lu exits. Last seen is %d\n", pthread_self(), cnt);
    pthread_exit((void *)lastSeen); // ทำการ exit thread โดยส่งค่า lastSeen
                                    // ไปให้ parent thread
  }
}
int main() {
  /**
   * D
   */
  sem_init(&mySemaphore, 0, 1); // ทำการ initialize semaphore โดยกำหนดค่าเริ่มต้น
                                // ให้เท่ากับ 1
  pthread_attr_init(&attr[0]); // ทำการ initialize attribute ของ thread ที่ 0
  pthread_attr_init(&attr[1]); // ทำการ initialize attribute ของ thread ที่ 1
  pthread_create(&tid[0], &attr[0], Count, NULL); // สร้าง thread ที่ 0
  pthread_create(&tid[1], &attr[1], Count, NULL); // สร้าง thread ที่ 1
  void *returnVal;
  pthread_join(tid[0], &returnVal); // รอให้ thread ที่ 0 ทำงานเสร็จ โดยรอค่าที่
                                    // return มาจาก thread ที่ 0
  int x = *(int *)returnVal; // ทำการ cast ค่าที่ return มาจาก thread ที่ 0
                             // ให้เป็น int
  printf("Last count from tid[0] is %d\n", x);

  pthread_join(tid[1], NULL); // รอให้ thread ที่ 1 ทำงานเสร็จ

  printf("Final count from tid[1] is %d\n", cnt);
  sem_destroy(&mySemaphore); // ทำการ destroy semaphore
  return 0;
}