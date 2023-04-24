package CSMovie;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MovieCounter {

  ArrayList<CSMovie> mList = new ArrayList<>();
  Set<String> uniqueTitle = new HashSet<>();

  public MovieCounter() {
    String row;
    int rowCount = 1;
    int incompleteCount = 0;
    String title;
    String rating;
    String genre;
    Integer year;
    String skipped_released;
    Double score;
    Integer votes;
    String director;
    String skipped_writer;
    String star;
    String country;
    Integer budget;
    Long gross;
    String company;
    Integer runtime;

    try (
      Scanner input = new Scanner(
        Paths.get(System.getProperty("user.dir") + "/CSMovie/Movies.csv")
      )
    ) {
      input.nextLine(); //skip header row
      while (input.hasNext()) {
        row = input.nextLine();
        rowCount++;
        String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        if (tokens.length < 15) {
          incompleteCount++;
          System.out.println(
            rowCount + " " + incompleteCount + " is incompleted"
          );
          continue; //skip this row
        }
        title = tokens[0];
        rating = tokens[1];
        genre = tokens[2];
        year = Integer.parseInt(tokens[3]);
        score = Double.parseDouble(parseDouble(tokens[5]));
        votes = (int) (Double.parseDouble(parseDouble(tokens[6])));
        director = tokens[7];
        star = tokens[9];
        country = tokens[10];
        budget = (int) (Double.parseDouble(parseDouble(tokens[11])));
        gross = (long) (Double.parseDouble(parseDouble(tokens[12])));
        company = tokens[13];
        runtime = (int) (Double.parseDouble(parseDouble(tokens[14])));
        if (!uniqueTitle.contains(title)) {
          mList.add(
            new CSMovie(
              title,
              rating,
              genre,
              year,
              score,
              votes,
              director,
              star,
              country,
              budget,
              gross,
              company,
              runtime
            )
          );
        }
        uniqueTitle.add(title);
      }
      System.out.print(
        "There are " + incompleteCount + " rows of incompleted data "
      );
      System.out.println(
        "from " +
        rowCount +
        " rows. (" +
        uniqueTitle.size() +
        ") unique titles."
      );
      System.out.println("list size is " + mList.size());
    } catch (IOException e) {
      System.out.println("from IO error");
      e.printStackTrace();
    }
  }

  private static String parseDouble(String str) {
    if (str.isEmpty()) return ".0";
    return str;
  }

  public Double q1() {
    // Show the average score of all movies
    double avgScore = mList
      .stream()
      .mapToDouble(CSMovie::getScore)
      .average()
      .getAsDouble();
    return avgScore;
  }

  public List<CSMovie> q2() {
    // Show movie's votes > 1_900_000
    List<CSMovie> list = mList
      .stream()
      .filter(m -> m.getVotes() > 1_900_000)
      .collect(Collectors.toList());
    return list;
  }

  public CSMovie q3() {
    // Show movie's gross maximum
    Optional<CSMovie> m = mList
      .stream()
      .max(Comparator.comparing(CSMovie::getGross));
    return m.get();
  }

  public List<String> q4() {
    // Show moveie's genre list
    List<String> list = mList
      .stream()
      .map(CSMovie::getGenre)
      .distinct()
      .sorted()
      .collect(Collectors.toList());
    return list;
  }

  public List<String> q5() {
    // Show movie's title and runtime (lowest 5)
    List<String> list = mList
      .stream()
      .sorted(Comparator.comparing(CSMovie::getRuntime))
      .map(e -> String.format("%-55s --> %s", e.getTitle(), e.getRuntime()))
      .limit(5)
      .collect(Collectors.toList());
    return list;
  }

  public CSMovie[] q6() {
    // Show movie's title and budget (highest and lowest)
    CSMovie arr[] = new CSMovie[2];
    Optional<CSMovie> highest = mList
      .stream()
      .max(Comparator.comparing(CSMovie::getBudget));
    Optional<CSMovie> lowest = mList
      .stream()
      .min(Comparator.comparing(CSMovie::getBudget));
    arr[0] = highest.get();
    arr[1] = lowest.get();
    return arr;
  }

  public List<CSMovie> q7(String genre) {
    // Show top 3 movie by genre sorted by score (descending)
    List<CSMovie> list = mList
      .stream()
      .filter(m -> m.getGenre().contains(genre))
      .sorted(Comparator.comparing(CSMovie::getScore).reversed())
      .limit(3)
      .collect(Collectors.toList());
    return list;
  }

  public List<CSMovie> q8() {
    // Show top 3 action movie sorted by score (descending) if score is same then sort by title (ascending)
    List<CSMovie> list = mList
      .stream()
      .filter(m -> m.getGenre().contains("Action"))
      .sorted(
        Comparator
          .comparing(CSMovie::getScore)
          .reversed()
          .thenComparing(CSMovie::getTitle)
      )
      .limit(3)
      .collect(Collectors.toList());
    return list;
  }

  public Map<String, Long> q9() {
    // Show total gross of genre
    Map<String, Long> map = mList
      .stream()
      .collect(
        Collectors.groupingBy(
          CSMovie::getGenre,
          Collectors.summingLong(CSMovie::getGross)
        )
      );
    return map;
  }

  public Map<String, Long> q10() {
    // Show top 10 of company sorted by movie count (descending) and number of movie (ascending)
    Map<String, Long> map = mList
      .stream()
      .collect(
        Collectors.groupingBy(CSMovie::getCompany, Collectors.counting())
      );
    map =
      map
        .entrySet()
        .stream() // value: count, key: company
        .sorted(
          Map.Entry
            .<String, Long>comparingByValue()
            .thenComparing(Map.Entry.comparingByKey())
            .reversed()
        )
        .limit(10)
        .collect(
          Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (e1, e2) -> e1,
            LinkedHashMap::new
          )
        );
    return map;
  }

  public CSMovie q11() {
    // Show movie's title most "a" words in title
    Optional<CSMovie> movie = mList
      .stream()
      .max(Comparator.comparing(m -> m.getTitle().split("a", -1).length - 1));
    return movie.get();
  }
}
// https://www.baeldung.com/java-split-string-commas
