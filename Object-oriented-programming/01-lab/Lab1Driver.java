import java.util.ArrayList;

public class Lab1Driver {
    static Lab1Coder keng;
    static Lab1Coder somsri;
    
    public static void main(String[] args) {
        // q1();
        q2_properConstructor();
        q3();
    }

    // static void q1() {
    //     Lab1Coder santa = new Lab1Coder();
    //     santa.setName("Santa");
    //     santa.setExperience(3);
    //     String str = String.format("%s has been working for %d years.", santa.getName(), santa.getExperience());
    //     System.out.println(str);
    // }

    static void q2_properConstructor() {
        somsri = new Lab1Coder("Somsri", 5);
        somsri.setLanguages("javascript", "dart");
        System.out.println(somsri.getLanguages());
    }

    static void q3() {
        keng = new Lab1Coder("Keng", 2);
        keng.setLanguages("java", "solidity", "c");
        Lab1Coder ber3 = new Lab1Coder("ber3");
        ber3.setLanguages("c", "java", "typescript");
        System.out.println(ber3);

        ArrayList<String> commonLanguages = ber3.findCommonLanguages(somsri);
        System.out.println(commonLanguages);
        commonLanguages = keng.findCommonLanguages(ber3);
        System.out.println(commonLanguages);
    }
}