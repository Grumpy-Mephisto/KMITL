public class Alarm {
    private Sprinkler sprinkler;
    private CoffeePot coffeePot;

    public Alarm(Sprinkler sprinkler, CoffeePot coffeePot) {
        this.sprinkler = sprinkler;
        this.coffeePot = coffeePot;
    }

    public void doAlarm() {
        System.out.println("Alarm is sending event to all...");
        sprinkler.doSprinkler(this);
        coffeePot.doCoffeePot(this);
    }

    public void endAlarm(String from) {
        System.out.println("Alarm event ended from " + from);
    }
}
