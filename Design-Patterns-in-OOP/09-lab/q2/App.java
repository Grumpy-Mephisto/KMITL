import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        FootballScoreTracker scoreTracker = new FootballScoreTracker();

        ScoreObserver thai = new FootballTable("Thai");
        ScoreObserver uae = new FootballTable("UAE");

        scoreTracker.registerObserver(thai);
        scoreTracker.registerObserver(uae);

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Enter Score (หรือกด Enter เพื่อจบโปรแกรม): ");
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("จบโปรแกรม");
                break;
            }

            scoreTracker.setScore(input);
        }

        scanner.close();
    }
}
