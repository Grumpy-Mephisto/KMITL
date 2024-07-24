#include <stdio.h>

#define PI 3.14

double circleArea(double r);

int main() {
  printf("area = %f\n", circleArea(3 + 2));
  printf("area = %f\n", circleArea(3.5 + 2));
}

double circleArea(double r) {
  return PI * r * r;
}
