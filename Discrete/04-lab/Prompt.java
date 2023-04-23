import SpanningTree.*;
import java.util.ArrayList;

public class Prompt {
    private ArrayList<Edge> citiesList;
    
    public Prompt() {
        Welcome();
        citiesList = new ArrayList<Edge>();
    }

    private void Welcome() {
        System.out.println("========================================================");
        System.out.println("Welcome to the Prim's Algorithm");
        System.out.println("========================================================");
    }

    public void User(ArrayList<Edge> cities) {
        System.out.println("What city would you like to start at?");
        
        int cityCount = 1;
        for(int i = 0; i < cities.size(); i++) {
            boolean cityInList = false;

            for(int j = 0; j < i; j++) {
                if(cities.get(i).getCityFrom().equals(cities.get(j).getCityFrom())) {
                    cityInList = true;
                    break;
                }
            }

            if(!cityInList) {
                System.out.printf("%d. %s\n", cityCount, cities.get(i).getCityFrom());
                citiesList.add(cities.get(i));
                cityCount++;
            }
        }
    }

    public String CityName(int cityNumber) {
        switch(cityNumber) {
            case 1:
                return citiesList.get(0).getCityFrom();
            case 2:
                return citiesList.get(1).getCityFrom();
            case 3:
                return citiesList.get(2).getCityFrom();
            case 4:
                return citiesList.get(3).getCityFrom();
            case 5:
                return citiesList.get(4).getCityFrom();
            case 6:
                return citiesList.get(5).getCityFrom();
            case 7:
                return citiesList.get(6).getCityFrom();
            default:
                return "Invalid city number";
        }
    }
}
