package devices.states;

import devices.Device;

/**
 * Cihaz açık durumdayken geçerli olan davranışları tanımlar.
 */
public class OnState implements DeviceState {

    @Override
    public void turnOn(Device device) {
        System.out.println(device.getName() + " zaten açık.");
    }

    @Override
    public void turnOff(Device device) {
        System.out.println(device.getName() + " kapatılıyor...");
        device.setState(new OffState());
    }

    @Override
    public String getStateName() {
        return "ON";
    }
}
