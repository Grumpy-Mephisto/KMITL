import java.io.*;
import java.util.*;

public class ReadCSV {

  static final String OS = System.getProperty("os.name");
  static final String RESET = "\u001B[0m";
  static final String RED = "\u001B[31m";
  static final String DATASET = "employee.csv";

  static void loading(int n, String message) {
    String tab[] = {
        " [=     ]",
        " [ =    ]",
        " [  =   ]",
        " [   =  ]",
        " [    = ]",
        " [     =]",
        " [    = ]",
        " [   =  ]",
        " [  =   ]",
        " [ =    ]"
    };

    for (int i = 0; i < n; i++) {
      System.out.print("\r" + message + tab[i % tab.length]);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static void clearConsole() {
    try {
      if (OS.contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.printf("\033\143");
      }
    } catch (IOException | InterruptedException e) {
      System.out.println(e.getMessage());
      System.exit(1);
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the max of Array: ");
    int n = sc.nextInt();
    sc.close();
    clearConsole();

    loading(10, "Wait a moment");
    clearConsole();
    Employee[] employee = new Employee[n];
    int errorLines = 1;
    int i = 0;

    try {
      File file = new File(DATASET);
      Scanner input = new Scanner(file);
      while (input.hasNext()) {
        try {
          String line = input.nextLine();
          String[] tokens = line.split(",");
          for (int j = 0; j < tokens.length; j++) {
            tokens[j] = tokens[j].trim();
          }
          int id = Integer.parseInt(tokens[0]);
          String name = tokens[1];
          String surname = tokens[2];
          Double salary = Double.parseDouble(tokens[3]);
          employee[i] = new Employee(id, name, surname, salary);
          i++;
        } catch (ArrayIndexOutOfBoundsException e) {
          System.out.println(
            RED + "Array is full – cannot load remaining rows" + RESET
          );
        } catch (Exception e) {
          System.out.println(
            RED + "Data format error at line: " + errorLines + "; " + e + RESET
          );
        }
        errorLines++;
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
      try {
        File file = new File(DATASET);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("1afdfd, Test, test, 12345.67");
        bw.newLine();
        bw.write("12345,John,Henry,456789.50");
        bw.newLine();
        bw.write("12346,Marry,Jane,56789.50");
        bw.newLine();
        bw.write("12346, test1, test1, 1o23.45");
        bw.newLine();
        bw.write("12347,Clark,Kent,78956.75");
        bw.close();
        fw.close();
        Thread.sleep(1000);
        clearConsole();
        System.out.println("File created, please run again");
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
      System.exit(1);
    }

    for (Employee e : employee) {
      if (e != null) {
        System.out.println(e.getEmployeeInfo());
      }
    }
  }
}

class Employee {

  private int empId;
  private String firstName, lastName;
  private double salary;

  public Employee() {
    this(0, "", "", 0.0);
  }

  public Employee(int empId, String firstName, String lastName, double salary) {
    this.empId = empId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.salary = salary;
  }

  public void setEmpId(int empId) {
    this.empId = empId;
  }

  public int getEmpId() {
    return empId;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public double getSalary() {
    return salary;
  }

  public String getEmployeeInfo() {
    return empId + " " + firstName + " " + lastName + " " + salary;
  }
}
