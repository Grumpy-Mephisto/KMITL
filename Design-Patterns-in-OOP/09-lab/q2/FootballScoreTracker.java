import java.util.ArrayList;
import java.util.List;

public class FootballScoreTracker implements ScoreSubject {
    private List<ScoreObserver> observers;
    private String scoreData;

    public FootballScoreTracker() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(ScoreObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(ScoreObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ScoreObserver observer : observers) {
            observer.update(scoreData);
        }
    }

    public void setScore(String score) {
        this.scoreData = score;
        notifyObservers();
    }

    public String getScore() {
        return scoreData;
    }
}
