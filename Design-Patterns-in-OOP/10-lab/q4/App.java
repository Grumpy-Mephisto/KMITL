public class App {
    public static void main(String[] args) {
        // Create mediator
        Alarm alarm = new Alarm();

        // Create colleagues
        Sprinkler sprinkler = new Sprinkler();
        CoffeePot coffeePot = new CoffeePot();

        // Register colleagues with mediator
        alarm.registerDevice(sprinkler);
        alarm.registerDevice(coffeePot);

        // Trigger the alarm to notify all devices
        alarm.doAlarm();
    }
}
