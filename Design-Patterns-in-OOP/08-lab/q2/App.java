public class App {
    public static void main(String[] args) {
        Employee ceo = new Employee("Settha", "CEO", 500000);

        Employee headSales = new Employee("Kamphaka", "Head Sales", 300000);
        Employee headMarketing = new Employee("UngInk", "Head Marketing", 300000);

        ceo.add(headSales);
        ceo.add(headMarketing);

        Employee salesEmployee1 = new Employee("Wiroj", "Sales", 150000);
        Employee salesEmployee2 = new Employee("Weeranan", "Sales", 100000);

        headSales.add(salesEmployee1);
        headSales.add(salesEmployee2);

        Employee marketingEmployee1 = new Employee("Oak", "Marketing", 200000);
        Employee marketingEmployee2 = new Employee("Aem", "Marketing", 250000);

        headMarketing.add(marketingEmployee1);
        headMarketing.add(marketingEmployee2);

        printAllEmployee(ceo);
    }

    public static void printAllEmployee(Employee employee) {
        printAllEmployee(employee, 0);
    }

    private static void printAllEmployee(Employee employee, int level) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indentation.append("\t");
        }

        System.out.println(indentation.toString() + employee);

        for (Employee subordinate : employee.getSubordinates()) {
            printAllEmployee(subordinate, level + 1);
        }
    }
}
