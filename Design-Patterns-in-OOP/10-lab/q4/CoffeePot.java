public class CoffeePot implements Colleague {
    private Mediator mediator;
    private String name = "Coffee Pot";

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveEvent(String event) {
        if (event.equals("activate")) {
            doCoffeePot();
        }
    }

    public void doCoffeePot() {
        System.out.println("I am coffee pot,... doing my task");
        mediator.receiveEvent(name, "completed");
    }

    @Override
    public String getName() {
        return name;
    }
}
