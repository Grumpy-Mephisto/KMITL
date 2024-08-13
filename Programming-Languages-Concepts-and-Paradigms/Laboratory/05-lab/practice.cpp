#include <iostream>
#include <string>

using namespace std;

int main() {
  string s1 = "This is the house that Jack built.";
  cout << s1.substr(0,4) << endl;
  cout << s1.substr(5,2) << endl;
  cout << s1.find("This") << endl;
  cout << s1.find('J') << endl;
  cout << s1.find("is", 4) << endl;
  cout << s1.length() << endl;
  cout << s1.erase(0,5) << endl;
  cout << s1.length() << endl;
}
