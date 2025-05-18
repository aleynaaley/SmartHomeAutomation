package devices.states;

import devices.Device;

/**
 * Cihaz kapalı durumdayken geçerli olan davranışları tanımlar.
 */
public class OffState implements DeviceState {

    @Override
    public void turnOn(Device device) {
        System.out.println(device.getName() + " açılıyor...");
        device.setState(new OnState());
    }

    @Override
    public void turnOff(Device device) {
        System.out.println(device.getName() + " zaten kapalı.");
    }

    @Override
    public String getStateName() {
        return "OFF";
    }
}
