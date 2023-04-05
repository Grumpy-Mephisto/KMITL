import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import packExercise.*;

public class Lab9_650437 {

  static ArrayList<Employee> empList;

  static {
    empList = new ArrayList<>();
    try (Scanner input = new Scanner(Paths.get("packExercise//names.csv"))) {
      input.nextLine(); // skip first row
      while (input.hasNext()) {
        String row = input.nextLine().trim();
        empList.add(new Employee(row));
      }
      System.out.println("There are " + empList.size() + " employees.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    System.out.println("ex1------");
    ex1();
    System.out.println("ex2------");
    ex2();
    System.out.println("ex3------");
    ex3();
    System.out.println("ex4------");
    ex4();
    System.out.println("ex5------");
    ex5();
    System.out.println("Q1------");
    q6();
    System.out.println("Q2------");
    q7();
    System.out.println("Q3------");
    q8();
    System.out.println("Q4------");
    q9();
    System.out.println("Q5------");
    q10();
    System.out.println("Q6------");
    q11();
    System.out.println("Q7------");
    q12();
    System.out.println("Q8------");
    q13();
    System.out.println("Q9------");
    q14();
    System.out.println("Q10------");
    q15();
  }

  static void ex1() {
    // hasCode() vs System.identityHashCode()
    Employee emp1 = new Employee("yindee");
    Employee emp2 = new Employee("yindee");
    int id1 = emp1.hashCode();
    int id2 = emp2.hashCode();
    String s1 = Integer.toHexString(id1);
    String s2 = Integer.toHexString(id2);
    System.out.println(s1);
    System.out.println(s2 + " " + s1.compareTo(s2));
  }

  static void ex2() {
    // java creates a copy of the reference when an obj is passed to a method.
    // changes to an obj will be effected
    Employee emp1 = new Employee("preeda");
    System.out.println(emp1);
    ex2_1(emp1);
    System.out.println(emp1);
  }

  private static void ex2_1(Employee e) {
    e.setName("aba abi abo abe");
  }

  static void ex3() {
    // changes to an obj will be effected when passing as a parameter but
    // not a collection
    ArrayList<Employee> singers = new ArrayList<>();
    singers.add(new Employee("aba"));
    singers.add(new Employee("abi"));
    singers.add(new Employee("abo"));
    singers.add(new Employee("abe"));
    ex3_1(singers);
    System.out.println(singers.get(0)); // cha cha cha
    System.out.println(singers); // not empty because it's list who changes
  }

  private static void ex3_1(List<Employee> list) {
    list.get(0).setName("cha cha cha"); // changes takes effect
    list = new ArrayList<>(); // changes takes "no" effect on collection
  }

  static void ex4() {
    // what if we do need to change the referenced object to another
    ArrayList<Employee> singers = new ArrayList<>();
    singers = ex4_1();
    System.out.println(singers);
  }

  private static ArrayList<Employee> ex4_1(/* List<Employee> list */) {
    ArrayList<Employee> list = new ArrayList<>();
    // whether list is passed in or newly allocated, it's a local reference.
    list.add(new Employee("aba"));
    list.add(new Employee("abi"));
    return (ArrayList<Employee>) list;
  }

  static void ex5() {
    // collection clone is shallow copy
    ArrayList<Employee> singers = new ArrayList<>();
    singers.add(new Employee("aba"));
    singers.add(new Employee("abi"));
    singers.add(new Employee("abo"));
    singers.add(new Employee("abe"));

    @SuppressWarnings("unchecked") // by clone()
    List<Employee> tmp = (ArrayList<Employee>) singers.clone();
    tmp.get(0).setName("cha");
    System.out.println(singers);

    // by new ArrayList<>();
    tmp = new ArrayList<>(singers);
    tmp.get(1).setName("cha cha");
    System.out.println(singers);

    // by subList()
    tmp = singers.subList(0, singers.size() - 1);
    tmp.get(2).setName("cha cha cha");
    System.out.println(tmp);
  }

  static void q6() {
    List<Employee> singers1 = new ArrayList<Employee>(
      Arrays.asList(new Employee("aba"), new Employee("abi"))
    );
    // Arrays.asList() returns fixed sized ...but ArrayList is not fixed, hence can
    // call addAll()
    List<Employee> singers2 = new ArrayList<>();
    singers2.add(new Employee("abo"));
    singers2.add(new Employee("abe"));

    List<Employee> join = q6_1(singers1, singers2);

    System.out.println(singers1);
    System.out.println(singers2);
    System.out.println(join);
    singers1.addAll(singers2);
    System.out.println(singers1);
  }

  private static List<Employee> q6_1(List<Employee> l1, List<Employee> l2) {
    List<Employee> mergeList = new ArrayList<>();
    mergeList.addAll(l1);
    mergeList.addAll(l2);
    return mergeList;
  }

  static void q7() {
    List<Employee> list1 = Arrays.asList(
      new Employee("yindee"),
      new Employee("pramote")
    );
    List<Employee> list2 = Arrays.asList(
      new Employee("preeda"),
      new Employee("yindee")
    );
    Set<Employee> empSet = new HashSet<>();
    empSet.addAll(list1);
    empSet.addAll(list2);
    List<Employee> empList = new ArrayList<>(empSet);
    System.out.println(empList);
  }

  private static List<Employee> q7_1(List<Employee> list) {
    return Arrays.asList(list.get(0));
  }

  static void q8() {
    List<Employee> list1 = Arrays.asList(
      new Employee("yindee"),
      new Employee("pramote")
    );
    List<Employee> list2 = Arrays.asList(
      new Employee("pramote"),
      new Employee("preeda")
    );
    Set<Employee> empSet = new HashSet<>();
    empSet.addAll(list1);
    empSet.addAll(list2);
    List<Employee> empList = new ArrayList<>(empSet);
    System.out.println(empList);
  }

  static void q9() {
    List<Employee> list1 = new ArrayList<>();
    list1.add(new Employee("yindee"));
    list1.add(new Employee("preeda"));
    list1.add(new Employee("pramote"));
    Set<Employee> empSet1 = new HashSet<>(list1);
    List<Employee> list2 = new ArrayList<>();
    list2.add(new Employee("yindee"));
    list2.add(new Employee("pramote"));
    Set<Employee> empSet2 = new HashSet<>(list2);
    empSet1.retainAll(empSet2);
    System.out.println(empSet1);
  }

  static void q10() {
    List<Employee> list1 = new ArrayList<>();
    list1.add(new Employee("yindee"));
    list1.add(new Employee("preeda"));
    list1.add(new Employee("pramote"));
    Set<Employee> empSet1 = new HashSet<>(list1);
    List<Employee> list2 = new ArrayList<>();
    list2.add(new Employee("yindee"));
    list2.add(new Employee("pramote"));
    Set<Employee> empSet2 = new HashSet<>(list2);
    empSet1.removeAll(list2);
    System.out.println(empSet1);
  }

  static void q11() {
    Set<Employee> empSet = new HashSet<>();
    empSet.add(new Employee("yindee"));
    empSet.add(new Employee("pramote"));
    empSet.add(new Employee("preeda"));
    empSet.add(new Employee("pramote"));
    Employee[] q11_ans = new Employee[empSet.size()];
    q11_ans = empSet.toArray(q11_ans);
    for (Employee e : q11_ans) System.out.print(e + " ");
    System.out.println();
  }

  static void q12() {
    int n = 3;
    Map<String, Employee> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (i > n) break;
      Employee emp = empList.get(i);
      map.put(emp.getName(), emp);
    }
    System.out.println(map);
  }

  static void q13() {
    int n = 3;
    Map<String, Employee> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (i > n) break;
      Employee emp = empList.get(i);
      map.put(emp.getName(), emp);
    }

    Set<String> keySet = new HashSet<>();

    for (Map.Entry<String, Employee> entry : map.entrySet()) {
      keySet.add(entry.getKey());
    }

    System.out.println(keySet);
  }

  static void q14() {
    PriorityQueue<Employee> pq = new PriorityQueue<>((e1, e2) ->
      Integer.compare(e1.getSalary(), e2.getSalary())
    );
    pq.addAll(empList);
    List<Employee> q14_ans = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      q14_ans.add(pq.poll());
    }
    System.out.println(q14_ans);
  }

  static void q15() {
    int sum = 0;
    int cnt = 0;
    Iterator<Employee> it;
    Long pqStart = System.nanoTime(); // System.currentTimeMillis();
    sum = 0;
    PriorityQueue<Employee> pq = new PriorityQueue<>((e1, e2) ->
      Integer.compare(e1.getSalary(), e2.getSalary())
    );
    pq.addAll(empList);
    it = pq.iterator();
    while (it.hasNext()) {
      sum += it.next().getSalary();
      cnt++;
    }
    System.out.println(
      "PQ (" +
      sum +
      ") takes " +
      String.format("%,d", System.nanoTime() - pqStart)
    );
    Long listStart = System.nanoTime();
    ArrayList<Employee> clone = new ArrayList<>();
    sum = 0;
    clone.addAll(empList);
    Collections.sort(
      clone,
      (e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary())
    );
    it = clone.iterator();
    while (it.hasNext()) {
      sum += it.next().getSalary();
      cnt--;
    }
    System.out.println(
      "ArrayList (" +
      sum +
      ") takes " +
      String.format("%,d", System.nanoTime() - listStart)
    );
    if (cnt != 0) System.out.println("error on number of elements");
  }
  // PQ
  // PQ เร็วกว่า Sort เพราะว่า PQ มีการเรียงลำดับข้อมูลแล้ว แต่ Sort ต้องเรียงลำดับก่อน
}
