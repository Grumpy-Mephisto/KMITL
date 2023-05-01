public enum Time {
    pm12("12 PM"),
    pm1("1 PM"),
    pm2("2 PM"),
    pm3("3 PM"),
    pm4("4 PM"),
    pm5("5 PM"),
    pm6("6 PM");

    private String hourName;

    Time(String hourName) {
        this.hourName = hourName;
    }

    public String getHourName() {
        return hourName;
    }

    @Override
    public String toString() {
        return "Time{" +
                "hourName='" + hourName + '\'' +
                '}';
    }
}
