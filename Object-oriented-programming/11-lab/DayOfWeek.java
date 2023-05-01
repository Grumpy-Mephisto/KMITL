public enum DayOfWeek {
    Mon("Monday"),
    Tue("Tuesday"),
    Wed("Wednesday"),
    Thr("Thursday"),
    Fri("Friday");

    private String dayName;

    DayOfWeek(String dayName) {
        this.dayName = dayName;
    }

    public String getDayName() {
        return dayName;
    }

    @Override
    public String toString() {
        return "DayOfWeek{" +
                "dayName='" + dayName + '\'' +
                '}';
    }
}
