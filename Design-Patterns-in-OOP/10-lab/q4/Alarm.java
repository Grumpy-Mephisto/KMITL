import java.util.ArrayList;
import java.util.List;

public class Alarm implements Mediator {
    private List<Colleague> devices;

    public Alarm() {
        this.devices = new ArrayList<>();
    }

    @Override
    public void registerDevice(Colleague device) {
        devices.add(device);
        device.setMediator(this);
        System.out.println("Device " + device.getName() + " registered with Alarm system");
    }

    @Override
    public void notifyDevices() {
        System.out.println("Alarm is sending event to all...");
        for (Colleague device : devices) {
            device.receiveEvent("activate");
        }
    }

    @Override
    public void receiveEvent(String from, String event) {
        System.out.println("Alarm event ended from " + from);
    }

    public void doAlarm() {
        notifyDevices();
    }
}
