package SpanningTree;

import java.util.ArrayList;

public class Data {

  public Data() {
    setData();
  }

  private ArrayList<String[]> setData() {
    ArrayList<String[]> data = new ArrayList<String[]>();
    data.add(new String[] { "Minneapolis", "Chicago", "355" });
    data.add(new String[] { "Minneapolis", "Nashville", "695" });
    data.add(new String[] { "Chicago", "St. Louis", "262" });
    data.add(new String[] { "Chicago", "Milwaukee", "74" });
    data.add(new String[] { "Chicago", "Louisville", "269" });
    data.add(new String[] { "St. Louis", "Louisville", "242" });
    data.add(new String[] { "Milwaukee", "Louisville", "348" });
    data.add(new String[] { "Nashville", "Louisville", "151" });
    data.add(new String[] { "Louisville", "Cincinnati", "83" });
    data.add(new String[] { "Louisville", "Detroit", "306" });
    data.add(new String[] { "Cincinnati", "Detroit", "230" });
    return data;
  }

  public ArrayList<String[]> getData() {
    return setData();
  }
}
