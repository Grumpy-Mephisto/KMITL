package pack10_CSMovie;

public class CSMovie {

  private String title;
  private String rating;
  private String genre;
  private Integer year;
  private String skipped_released;
  private Double score;
  private Integer votes;
  private String director;
  private String skipped_writer;
  private String star;
  private String country;
  private Integer budget;
  private Long gross;
  private String company;
  private Integer runtime;

  public CSMovie(
    String title,
    String rating,
    String genre,
    Integer year,
    Double score,
    Integer votes,
    String director,
    String star,
    String country,
    Integer budget,
    Long gross,
    String company,
    Integer runtime
  ) {
    this.title = title;
    this.rating = rating;
    this.genre = genre;
    this.year = year;
    this.score = score;
    this.votes = votes;
    this.director = director;
    this.star = star;
    this.country = country;
    this.budget = budget;
    this.gross = gross;
    this.company = company;
    this.runtime = runtime;
  }

  public CSMovie(String line) {
    String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
    if (tokens.length == 15) {
      title = tokens[0];
      rating = tokens[1];
      genre = tokens[2];
      year = Integer.parseInt(tokens[3]);
      score = Double.parseDouble(tokens[5]);
      String[] token6 = tokens[6].split(".");
      //System.out.println(title + " " + tokens[6]);
      //token6[0] = token6[0].isEmpty()?"0" : token6[0];
      votes = Integer.parseInt(token6[0]);
      director = tokens[7];
      star = tokens[9];
      country = tokens[10];
      String token11 = tokens[11].isEmpty() ? "0" : tokens[11];
      budget = Integer.parseInt(token11);
      String token12 = tokens[12].isEmpty() ? "0" : tokens[12];
      gross = Long.parseLong(token12);
      company = tokens[13];
      String token14 = tokens[14].isEmpty() ? "0" : tokens[14];
      runtime = Integer.parseInt(token14);
    }
  }

  public String getTitle() {
    return title;
  }

  public String getRating() {
    return rating;
  }

  public String getGenre() {
    return genre;
  }

  public Integer getYear() {
    return year;
  }

  public Double getScore() {
    return score;
  }

  public Integer getVotes() {
    return votes;
  }

  public String getDirector() {
    return director;
  }

  public String getStar() {
    return star;
  }

  public String getCountry() {
    return country;
  }

  public Integer getBudget() {
    return budget;
  }

  public Long getGross() {
    return gross;
  }

  public String getCompany() {
    return company;
  }

  public Integer getRuntime() {
    return runtime;
  }

  @Override
  public String toString() {
    return (
      "CSMovie [title=" +
      title +
      ", rating=" +
      rating +
      ", genre=" +
      genre +
      ", year=" +
      year +
      ", score=" +
      score +
      ", votes=" +
      votes +
      ", director=" +
      director +
      ", star=" +
      star +
      ", country=" +
      country +
      ", budget=" +
      budget +
      ", gross=" +
      gross +
      ", company=" +
      company +
      ", runtime=" +
      runtime +
      "]"
    );
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    CSMovie other = (CSMovie) obj;
    if (title == null) {
      if (other.title != null) return false;
    } else if (!title.equals(other.title)) return false;
    return true;
  }
}
