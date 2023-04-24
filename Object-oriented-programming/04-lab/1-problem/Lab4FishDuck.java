import packA.*;

public class Lab4FishDuck {
    public static void main(String[] args) {
        q1();
    }

    static void q1() {
        Lec4Fish fish = new Lec4Fish();
        fish.swim();
        fish.fishMethod();
        
        Lec4Duck duck = new Lec4Duck();
        duck.swim();
        duck.duckMethod();
    }
}
