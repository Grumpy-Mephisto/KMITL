import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Lab8a {
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
    }

    public static void demo1() {
        System.out.println("===== DEMO 1 =====");
        SillyLuckyNumber[] arr = {new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")};
        System.out.println(Arrays.toString(arr));
        // Lambda expression
        Comparator<SillyLuckyNumber> engine =
                (o1, o2) -> Integer.compare(o1.getLuckyNumber(), o2.getLuckyNumber());
        Arrays.sort(arr, engine);
        System.out.println(Arrays.toString(arr));
    }

    public static void demo2() {
        System.out.println("===== DEMO 2 =====");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>(
                Arrays.asList(new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                        new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")));
        System.out.println(list);

        Collections.sort(list,
                (o1, o2) -> Integer.compare(o1.getLuckyNumber(), o2.getLuckyNumber()));

        System.out.println(list);
    }

    public static void demo3() {
        System.out.println("===== DEMO 3 =====");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>(
                Arrays.asList(new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                        new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")));
        System.out.println(list);
        list.sort(Comparator.comparingInt(SillyLuckyNumber::getLuckyNumber));
        System.out.println(list);

        // Demo shallow copy
        ArrayList<SillyLuckyNumber> anotherList = new ArrayList<>(list.subList(0, list.size()));
        anotherList.get(0).setBreed("newBreed");
        System.out.println(list);
        list.sort(Comparator.comparing(SillyLuckyNumber::getLuckyNumber));
        System.out.println(list);
    }

    public static void demo4() {
        System.out.println("===== DEMO 4 =====");
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        System.out.println(arr);
        arr.swap(1, 3);
        System.out.println(arr);
    }

    public static void demo5() {
        System.out.println("===== DEMO 5 =====");
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        arr.add(new SillyLuckyNumber("Cocker Spaniel"));
        arr.add(new SillyLuckyNumber("Basenji"));
        System.out.println(arr);
        // Selection sort
        selectionSort(arr);
        System.out.println(arr);
    }

    public static void selectionSort(MyArrDemo<SillyLuckyNumber> arr) {
        for (int i = 0; i < arr.currentSize() - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.currentSize(); j++) {
                if (arr.get(j).getLuckyNumber() < arr.get(minIndex).getLuckyNumber()) {
                    minIndex = j;
                }
            }
            arr.swap(i, minIndex);
        }
    }
}
