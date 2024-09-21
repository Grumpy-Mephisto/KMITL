#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

void main() {
  #pragma omp parallel
  {
    printf("Halo, I'm parallel\n");
  }
}
