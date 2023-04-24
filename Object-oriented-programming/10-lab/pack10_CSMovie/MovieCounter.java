package pack10_CSMovie;

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
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
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

        try(Scanner input = new Scanner(Paths.get(System.getProperty("user.dir") + "/pack10_CSMovie/movies.csv"))) {
            input.nextLine(); //skip header row
            while (input.hasNext()) {
                row = input.nextLine();
                rowCount++;
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (tokens.length < 15) {
                    incompleteCount++;
                    System.out.println(rowCount + " " + incompleteCount + " is incompleted");
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
                    mList.add(new CSMovie(title, rating, genre, 
                    year, score, votes, 
                    director, star, country, 
                    budget, gross, company, 
                    runtime));
                }
                uniqueTitle.add(title);
            }
            System.out.print("There are " + incompleteCount + " rows of incompleted data ");
            System.out.println("from " + rowCount + " rows. (" + uniqueTitle.size()+ ") unique titles.");
            System.out.println("list size is " + mList.size());
        } catch (IOException e) {
            System.out.println("from IO error");
            e.printStackTrace();
        }
    }
    private static String parseDouble(String str) {
        if (str.isEmpty())
            return ".0";
        return str;
    }

    public Double q1() {
        // Show the average score of all movies
        double avgScore = mList.stream()
            .mapToDouble(CSMovie::getScore)
            .average()
            .getAsDouble();
        return avgScore;
    }
    public List<CSMovie> q2() {
        // Show movie's votes > 1_900_000
        List<CSMovie> list = mList.stream()
            .filter(m -> m.getVotes() > 1_900_000)
            .collect(Collectors.toList());
        return list;
    }
    public CSMovie q3() {
        // Show movie's gross maximum
        Optional<CSMovie> m = mList.stream()
            .max(Comparator.comparing(CSMovie::getGross));
        return m.get();
    }   
    public List<String> q4() {
        // Show moveie's genre list
        List<String> list = mList.stream()
            .map(CSMovie::getGenre)
            .collect(Collectors.toList());
        return list;
    }
    public List<String> q5() { 
        // Show movie's title and runtime (last 5 movies)
        // Use map(e -> String.format("%-55s --> %s",e.getTitle(), e.getRuntime()))
        List<String> list = mList.stream()
            .sorted(Comparator.comparing(CSMovie::getRuntime).reversed())
            .limit(5)
            .map(e -> String.format("%-55s --> %s",e.getTitle(), e.getRuntime()))
            .collect(Collectors.toList());
        return list;
    }

    public CSMovie[] q6() {

    }

    public List<CSMovie> q7(String genre) {

    }
    public List<CSMovie> q8() {
       
    }
    public Map<String,Long> q9() {

    }
    public Map<String,Long> q10() {

    }
    public CSMovie q11() {
        // Function most 'a' 
        Function<CSMovie, Integer> countVowel = m -> {
            int cnt = 0;
            return cnt;
        };
        Optional<CSMovie> m;

        return m.get();
    }
}
// https://www.baeldung.com/java-split-string-commas