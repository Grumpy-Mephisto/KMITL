public interface Colleague {
    void setMediator(Mediator mediator);

    void receiveEvent(String event);

    String getName();
}
