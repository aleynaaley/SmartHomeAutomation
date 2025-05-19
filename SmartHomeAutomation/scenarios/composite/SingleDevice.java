package composite;

import devices.Device;

public class SingleDevice implements DeviceComponent {
    private Device device;

    public SingleDevice(Device device) {
        this.device = device;
    }

    @Override
    public void turnOn() {
        device.turnOn();
    }

    @Override
    public void turnOff() {
        device.turnOff();
    }

    @Override
    public void printStatus() {
        System.out.println(device.getName() + " is " + (device.isOn() ? "ON" : "OFF"));
    }

    public Device getDevice() {
        return device;
    }
}
