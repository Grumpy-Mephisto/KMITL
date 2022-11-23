import java.util.*;

public class Main {
    ArrayList<ProFun14Employee> eList;
    
    Main() {
        eList = new ArrayList<>();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main employees = new Main();
        int n = Integer.parseInt(sc.nextLine());
        try {
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                String department = sc.next();
                int salary = Integer.parseInt(sc.next());
                int year = Integer.parseInt(sc.next());
                employees.eList.add(new ProFun14Employee(name, department, salary, year));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        employees.EmpBefore2015();
        sc.close();
    }

    void EmpBefore2015() {
        int yearThreshold = 2015;
        List<String> empBefore2015 = new ArrayList<>();
        for (ProFun14Employee data : eList) {
            if (data.getYearStart() < yearThreshold) {
                empBefore2015.add(data.toString());
            }
        }
        System.out.println(empBefore2015);
    }
}

class ProFun14Employee {
    private String name;
    private int yearStart;
    private int salary;
    private String department;

    public ProFun14Employee(String name, String department, int salary, int yearStart) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.yearStart = yearStart;
    }

    public String getName() {
        return name;
    }

    public int getYearStart() {
        return yearStart;
    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return String.format("%s %s(%d) %d", department, name, yearStart, salary);
    }
}