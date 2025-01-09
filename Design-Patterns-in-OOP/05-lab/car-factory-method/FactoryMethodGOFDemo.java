public class FactoryMethodGOFDemo {
    public static void main(String[] args) {
        AutomobileDisplay fordDisplay = AutomobileDisplayFactory
                .createDisplay(AutomobileDisplayFactory.AutomobileType.FORD);
        AutomobileDisplay toyotaDisplay = AutomobileDisplayFactory
                .createDisplay(AutomobileDisplayFactory.AutomobileType.TOYOTA);

        System.out.println("Displaying Ford Automobile");
        fordDisplay.displayAutomobile();

        System.out.println("Displaying Toyota Automobile");
        toyotaDisplay.displayAutomobile();
    }
}
