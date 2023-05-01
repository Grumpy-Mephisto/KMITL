public enum City {
    BKK("Bangkok"),
    NRT("Tokyo Narita"),
    ICN("Incheon"),
    SIN("Singapore");

    private String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", airportCode='" + name() + '\'' +
                '}';
    }
}
