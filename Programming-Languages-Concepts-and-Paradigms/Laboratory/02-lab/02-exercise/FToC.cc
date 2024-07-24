#include <iomanip>
#include <iostream>

int main() {
  float fahrenheit, celsius;
  std::cout << "Enter the temperature in Fahrenheit: ";
  std::cin >> fahrenheit;
  celsius = (fahrenheit - 32) * 5 / 9;
  std::cout << std::fixed << std::setprecision(2);
  std::cout << fahrenheit << " Fahrenheit = " << celsius << " Celsius"
            << std::endl;
  return 0;
}