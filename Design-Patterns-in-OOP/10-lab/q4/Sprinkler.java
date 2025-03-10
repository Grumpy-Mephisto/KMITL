public class Sprinkler implements Colleague {
    private Mediator mediator;
    private String name = "Sprinkler";

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveEvent(String event) {
        if (event.equals("activate")) {
            doSprinkler();
        }
    }

    public void doSprinkler() {
        System.out.println("I am sprinkler,... doing my task");
        mediator.receiveEvent(name, "completed");
    }

    @Override
    public String getName() {
        return name;
    }
}
