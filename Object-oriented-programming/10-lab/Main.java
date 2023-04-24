import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import pack10_CSMovie.*;

public class Main {

  public static void main(String[] args) {
    // warmUp(args);
    // hintQ10();
    // hintQ11();
    MovieCounter mc = new MovieCounter();
    System.out.println("========== q1 ==========");
    q1(mc);
    System.out.println("========== q2 ==========");
    q2(mc);
    System.out.println("========== q3 ==========");
    q3(mc);
    System.out.println("========== q4 ==========");
    q4(mc);
    System.out.println("========== q5 ==========");
    q5(mc);
    // System.out.println("========== q6 ==========");
    // q6(mc);
    // System.out.println("========== q7 ==========");
    // args = new String[1]; //enumlate args in case command line misses this input
    // args[0] = "Action";
    // q7(mc,args[0]);
    // System.out.println("========== q8 ==========");
    // q8(mc);
    // System.out.println("========== q9 ==========");
    // q9(mc);
    // System.out.println("========== q10 ==========");
    // q10(mc);
    // System.out.println("========== q11 ==========");
    // q11(mc);
  }

  private static void q1(MovieCounter mc) {
    //average score
    Double ans = mc.q1();
    System.out.println("average score is " + String.format("%.2f", ans));
  }

  private static void q2(MovieCounter mc) {
    //List movies with votes greater than 1_900_000
    List<CSMovie> ans = mc.q2();
    for (CSMovie m : ans) {
      System.out.println(m);
    }
  }

  private static void q3(MovieCounter mc) {
    // high gross revenue movie
    CSMovie ans = mc.q3();
    System.out.printf("%s --> %d earns%n", ans.getTitle(), ans.getGross());
  }

  private static void q4(MovieCounter mc) {
    // number of genre
    List<String> ans = mc.q5();
    for (String s : ans) System.out.println(s);
  }

  private static void q5(MovieCounter mc) {
    //top 5 least runtime including 0 runtime
    List<String> ans = mc.q4();
    for (String m : ans) {
      System.out.println(m);
    }
  }

  private static void q6(MovieCounter mc) {
    //highest and lowest budget
    CSMovie[] ans = mc.q6();
    System.out.println(
      "highest -> " +
      ans[0].getTitle() +
      " " +
      String.format("%,d", ans[0].getBudget())
    );
    System.out.println(
      "Lowest -> " +
      ans[1].getTitle() +
      " " +
      String.format("%,d", ans[1].getBudget())
    );
  }

  private static void q7(MovieCounter mc, String genre) {
    // top 3 action movies
    List<CSMovie> ans = mc.q7(genre);
    for (CSMovie m : ans) {
      System.out.printf(
        "%-55s %s \t %f  %,15d %,15d%n",
        m.getTitle(),
        m.getGenre(),
        m.getScore(),
        m.getVotes(),
        m.getGross()
      );
    }
  }

  private static void q8(MovieCounter mc) {
    //top 4 action movies then by title
    List<CSMovie> ans = mc.q8();
    for (CSMovie m : ans) {
      System.out.println(m);
    }
  }

  private static void q9(MovieCounter mc) {
    //subtotal gross revenue of each genre
    Map<String, Long> ans = mc.q9();
    for (Entry<String, Long> entry : ans.entrySet()) {
      System.out.printf("%-20s %,18d%n", entry.getKey(), entry.getValue());
    }
  }

  private static void q10(MovieCounter mc) {
    // 10 companies with most movies produced
    Map<String, Long> ans = mc.q10();
    for (Entry<String, Long> entry : ans.entrySet()) {
      String str = String.format(
        "%-30s \t %,d",
        entry.getKey(),
        entry.getValue()
      );
      System.out.println(str);
    }
  }

  private static void q11(MovieCounter mc) {
    // show title with most 'a'
    System.out.println(mc.q11().getTitle());
  }

  private static void warmUp(String[] args) {
    System.out.println("**AAAAAAAA**");
    // learn behavior of args
    System.out.print("command arguments are ");
    for (String s : args) System.out.println(s.trim());
    System.out.println();

    System.out.println("**BBBBBBBB**");
    // review openning .csv file using .split()
    String row;
    String[] tokens;
    try (
      Scanner input = new Scanner(
        Paths.get(
          System.getProperty("user.dir") + "/pack10_CSMovie/Samples10.csv"
        )
      )
    ) {
      input.nextLine(); //skip header row
      while (input.hasNext()) {
        row = input.nextLine();
        tokens = row.split(",");
        for (String token : tokens) System.out.print(token + " ");
        System.out.println();
      }
    } catch (IOException e) {
      System.out.println("from IO error");
      e.printStackTrace();
    }
    System.out.println("**CCCCCCCC**");
    //test what if title contains comma(,)
    row = "\"This is, a sample title\", \"Horror\", \"10.0\"";
    tokens = row.split(",");
    System.out.println("There are " + tokens.length + " tokens");
    for (String token : tokens) System.out.println(token.trim() + " ");

    tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    System.out.println("There are " + tokens.length + " tokens");
    for (String token : tokens) System.out.println(token.trim() + " ");
  }

  private static void hintQ10() {
    Map<String, Integer> unordered = new HashMap<>();
    unordered.put("A", 12);
    unordered.put("C", 7);
    unordered.put("B", 20);

    Map<String, Integer> orderByValueMap;
    orderByValueMap =
      unordered
        .entrySet()
        .stream()
        .sorted(Entry.comparingByValue())
        .collect(
          Collectors.toMap(
            Entry::getKey,
            Entry::getValue,
            (e1, e2) -> e1,
            LinkedHashMap::new
          )
        );
    //add least value one by one, hence sorted
    for (Entry entry : orderByValueMap.entrySet()) System.out.println(
      entry.getKey() + " " + entry.getValue()
    );

    Map<String, Long> unorderedLong = new HashMap<>();
    unorderedLong.put("D", 12L);
    unorderedLong.put("E", 7L);
    unorderedLong.put("F", 20L);
    Map<String, Long> longAndReverseMap;
    longAndReverseMap =
      unorderedLong
        .entrySet()
        .stream()
        .sorted(
          Collections.reverseOrder(Entry.comparingByValue(Long::compareTo))
        )
        .collect(
          Collectors.toMap(
            Entry::getKey,
            Entry::getValue,
            (e1, e2) -> e1,
            LinkedHashMap::new
          )
        );
    for (Entry entry : longAndReverseMap.entrySet()) System.out.println(
      entry.getKey() + " " + entry.getValue()
    );
  }

  private static void hintQ11() {
    // count number of words in title
    Function<String, Integer> numWords = entry -> {
      String[] tokens = entry.split(" ");
      return tokens.length;
    };

    List<String> data = Arrays.asList(
      "one two three",
      "four five",
      "six seven eight nine"
    );
    Optional<String> opt = data.stream().max(Comparator.comparing(numWords));
    System.out.println(opt.get());
  }
}
