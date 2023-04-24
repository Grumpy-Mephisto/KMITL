import packA.*;
import java.util.ArrayList;

public class Lab4Employee {
    public static void main(String[] args) {
        q1();
        System.out.println("--------------------");
        q2();
    }

    static void q1() {
        String[] skills = new String[] {"Solidity", "Typescript"};
        ProgrammerManager pManager = new ProgrammerManager("CodeReviewer", 9, 550, skills);
        System.out.println(pManager);
        Employee e = pManager;
        e.sayHi();
    }

    static void q2() {
        String[] skills = new String[] {"Solidity", "Typescript"};
        ProgrammerManager pManager = new ProgrammerManager("CodeReviewer", 9, 550, skills);
        ArrayList<Programmer> aList = new ArrayList<>();
        aList.add(new Programmer("Keng", 2, 300));
        aList.add(new Programmer("Somsri", 3, 400));
        aList.add(new Programmer("haha", 4, 600));
        for(Programmer p : aList) {
            int newSalary = pManager.evaluate(p);
            System.out.printf("new salary is %d%n", newSalary);
        }
    }
}
