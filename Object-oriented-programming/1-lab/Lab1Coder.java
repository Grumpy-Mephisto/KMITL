import java.util.ArrayList;

public class Lab1Coder {
    private String name;
    private int experience;
    private ArrayList<String> languages;
    
    Lab1Coder(String n, int exp) {
        name = n;
        experience = exp;
        languages = new ArrayList<String>();
    }

    Lab1Coder(String n) {
        this(n, 0);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setLanguages(String ...lang) {
        for (String l : lang) {
            languages.add(l);
        }
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public String toString() {
        String str = String.format("%s(%d) knows ", name, experience);
        for (int i = 0; i < languages.size(); i++) {
            if (i == languages.size() - 1) {
                str += languages.get(i);
            } else {
                str += languages.get(i) + " ";
            }
        }
        return str;
    }

    public ArrayList<String> findCommonLanguages(Lab1Coder other) {
        ArrayList<String> common = new ArrayList<String>();
        for (String l : languages) {
            if (other.getLanguages().contains(l)) {
                common.add(l);
            }
        }
        if (common.size() == 0) {
            common.add("none");
        }
        return common;
    }
}