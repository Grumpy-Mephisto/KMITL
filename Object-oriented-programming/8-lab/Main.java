import Libs.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {

  public static void q1_halfEachNumber() {
    List<Integer> nums = Arrays.asList(100, 105);
    HalfValueInterface halfVal = n -> System.out.println(n / 2);
    for (int n : nums) {
      halfVal.printHalf(n);
    }
    Consumer<Integer> consumer = n -> {
      int ans = n / 2;
      System.out.println(ans);
    };
    for (int n : nums) {
      consumer.accept(n);
    }
    Consumer<Integer> halfMe = n -> System.out.println(n / 2);
    nums.forEach(halfMe);
    nums.forEach(
      consumer =
        n -> {
          System.out.println(n / 2);
        }
    );
    NumberProcessor np = new NumberProcessor();
    nums.forEach(np::printHalf);
  }

  public static void q2_forEachSingerName() {
    List<Singer> singerList = new ArrayList<>();
    singerList.add(new Singer("Aba"));
    singerList.add(new Singer("Abi"));
    singerList.add(new Singer("Abo"));
    singerList.add(new Singer("Abe"));
    singerList
      .stream()
      .map(name -> name.getName())
      .toList()
      .forEach(System.out::println);
    singerList
      .stream()
      .map(Singer::getName)
      .toList()
      .forEach(System.out::println);
  }

  public static void q3_lambda_comparator() {
    List<Singer> singerList = new ArrayList<>();
    singerList.add(new Singer("Aba", "POP"));
    singerList.add(new Singer("Abi", "ROCK"));
    singerList.add(new Singer("Abo", "POP"));
    singerList.add(new Singer("Abe", "ROCK"));
    Comparator<Singer> byStyle1 = new Comparator<>() {
      @Override
      public int compare(Singer o1, Singer o2) {
        return o1.getStyle().compareTo(o2.getStyle());
      }
    };
    Collections.sort(singerList, byStyle1);
    singerList.forEach(System.out::println);
    Comparator<Singer> byStyle2 = (Singer o1, Singer o2) ->
      o1.getStyle().compareTo(o2.getStyle());

    Collections.sort(singerList, byStyle2);
    singerList.forEach(System.out::println);
  }

  public static void q4_method_reference_comparator() {
    List<Singer> singerList = new ArrayList<>();
    singerList.add(new Singer("Aba", "POP"));
    singerList.add(new Singer("Abi", "ROCK"));
    singerList.add(new Singer("Abo", "POP"));
    singerList.add(new Singer("Abe", "ROCK"));
    Comparator<Singer> byName = Comparator.comparing(Singer::toSting);
    Collections.sort(singerList, byName);
    singerList.forEach(System.out::println);
    System.out.println("--------");
    singerList.sort((p, q) -> p.getStyle().compareTo(q.getStyle()));
    singerList.forEach(System.out::println);
  }

  public static void main(String[] args) {
    q1_halfEachNumber();
    q2_forEachSingerName();
    q3_lambda_comparator();
    q4_method_reference_comparator();
  }
}
