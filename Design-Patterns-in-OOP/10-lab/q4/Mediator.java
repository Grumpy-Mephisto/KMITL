public interface Mediator {
    void registerDevice(Colleague device);

    void notifyDevices();

    void receiveEvent(String from, String event);
}
