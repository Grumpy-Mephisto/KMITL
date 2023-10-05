#define TRUE 1
#define FALSE 0

/**
 * Memory structure for Peterson's algorithm.
 */
struct Memory {
  int turn;
  int flag[2];
};

/**
 * Initializes the Peterson's algorithm.
 *
 * @return void
 */
void initializePeterson();

/**
 * Removes the Peterson's algorithm.
 *
 * @return void
 */
void removePeterson();

/**
 * Enters the critical section.
 *
 * @param int process
 * @return void
 */
void enterCriticalSection(int process);

/**
 * Exits the critical section.
 *
 * @param int process
 * @return int
 */
int exitCriticalSection(int process);