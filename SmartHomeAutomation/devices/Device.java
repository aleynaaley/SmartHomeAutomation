package devices;

import devices.states.DeviceState;
import devices.states.OffState;

/**
 * Temel cihaz sınıfı, State desenine uygun olarak davranır.
 */
public abstract class Device {
    protected String name;
    protected DeviceState state;

    public Device(String name) {
        this.name = name;
        this.state = new OffState(); // Başlangıç durumu
    }

    public String getName() {
        return name;
    }

    public void setState(DeviceState newState) {
        this.state = newState;
    }

    public DeviceState getState() {
        return state;
    }

    public boolean isOn() {
        return "ON".equals(state.getStateName());
    }

    public void turnOn() {
        state.turnOn(this);
    }

    public void turnOff() {
        state.turnOff(this);
    }
}
