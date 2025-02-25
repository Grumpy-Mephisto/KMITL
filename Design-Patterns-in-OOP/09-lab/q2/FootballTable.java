public class FootballTable implements ScoreObserver {
    private String name;

    public FootballTable(String name) {
        this.name = name;
    }

    @Override
    public void update(String scoreData) {
        System.out.println("live result: " + scoreData + " <- แสดงผลให้ " + name);
    }
}
