import java.util.ArrayList;

import packA.*;

public class Lab3Polymorphism {
    public static void main(String[] args) {
        q1();
    }

    static void q1() {
        ArrayList<EmpTmp> aList = new ArrayList<>();
        aList.add(new Accountant("goodAtMyJob", 7, 6, 390, "sing"));
        aList.add(new Accountant("canRap", 4, 9, 480, "rap"));
        aList.add(new SalesPerson("mr.salesperson", 5, 150, 5000));
        aList.add(new SalesPerson("mr.kayan", 3, 260, 9000));
        aList.add(new Programmer("Keng", 2, 300));
        aList.add(new EmpTmp("invisible", 9, 120));

        System.out.println("UpCasting");
        for(EmpTmp e : aList) {
            e.sayHi();
        }

        System.out.println("DownCasting");
        for(EmpTmp e : aList) {
            String str;
            if(e instanceof Accountant) {
                str = ((Accountant)e).tellProfit();
            } else if(e instanceof SalesPerson) {
                str = ((SalesPerson)e).makeQuotation();
            } else if(e instanceof Programmer) {
                str = ((Programmer)e).coding();
            } else {
                str = "";
            }
            System.out.println(str);
        }
    }
}
