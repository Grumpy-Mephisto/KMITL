import java.util.*;
import java.util.stream.*;

public class Main {
    ArrayList<ProFun14Employee> eList;

    Main() {
        eList = new ArrayList<>();
        // eList.add(new ProFun14Employee("D", "HR", 9000, 2016));
        // eList.add(new ProFun14Employee("B", "IT", 5000, 2011));
        // eList.add(new ProFun14Employee("C", "IT", 6000, 2014));
        // eList.add(new ProFun14Employee("A", "Finance", 7000, 2018));
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
        String deptName = sc.next();
        sc.close();
        
        Main Employees = new Main();
        Employees.streamWay(deptName);
        Employees.oldWay(deptName);
    }
    
    void oldWay(String deptName) {
        String Query = "";
        // each query for each submission
        // eList is always the same for all queries
        Query = "Q1 list contains all employee's names";
        List<String> allEmployees = new ArrayList<>();
        for (ProFun14Employee data : eList) {
            allEmployees.add(data.getName());
        }
        System.out.println(allEmployees);

        Query = "Q2 List employee who has started work before 2015";
        int yearThreshold = 2015;
        List<String> empBefore2015 = new ArrayList<>();
        for (ProFun14Employee data : eList) {
            if (data.getYearStart() < yearThreshold) {
                empBefore2015.add(data.toString());
            }
        }
        System.out.println(empBefore2015);

        Query = "Q3 Compute sum of salaries of employee";
        int sumSalaries = 0;
        for(ProFun14Employee data : eList) {
            sumSalaries += data.getSalary();
        }
        System.out.println(sumSalaries);

        Query = "Q4 Employee with lowest salary";
        ProFun14Employee lowestSalary;
        lowestSalary = eList.get(0);
        for (ProFun14Employee data : eList) {
            if (data.getSalary() < lowestSalary.getSalary()) {
                lowestSalary = data;
            }
        }
        System.out.println(lowestSalary.toString());

        
        Query = "Q5 List employees who work in given dept name (same order on eList)";
        List<ProFun14Employee> equalsDept = new ArrayList<>();
        for (ProFun14Employee data : eList) {
            if (data.getDepartment().equals(deptName)) {
                equalsDept.add(data);
            }
        }
        if (equalsDept.size() == 0) {
            System.out.println("No employee found in the department");
        } else {
            for (ProFun14Employee dataEquals : equalsDept) {
                System.out.println(dataEquals.toString());
            }
        }
    }
    
    void streamWay(String deptName) {
        String Query = "Q1 list contains all employee's names";
        List<String> list = eList.stream().map(e -> e.getName()).collect(Collectors.toList());
        System.out.println(list);

        Query = "Q2 List employee who has started work before 2015";
        int yearThreshold = 2015;
        List<ProFun14Employee> empBefore2015;
        empBefore2015 = eList.stream().filter(e -> e.getYearStart() < yearThreshold).collect(Collectors.toList());
        System.out.println(empBefore2015);

        Query = "Q3 Compute sum of salaries of employee";
        int x = eList.stream().collect(Collectors.summingInt(ProFun14Employee::getSalary));
        System.out.printf("%,d%n", x);

        Query = "Q4 Employee with lowest salary";
        ProFun14Employee emp;
        emp = eList.stream().min(Comparator.comparing(ProFun14Employee::getSalary)).get();
        System.out.println(emp);
        
        Query = "Q5 List employees who work in given dept name (same order on eList)";
        List<ProFun14Employee> result = eList.stream().filter(e -> e.getDepartment().equals(deptName)).collect(Collectors.toList());
        System.out.println(result);
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
