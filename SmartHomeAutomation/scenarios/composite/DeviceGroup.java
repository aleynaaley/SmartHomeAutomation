package composite;

import java.util.ArrayList;
import java.util.List;

public class DeviceGroup implements DeviceComponent {
    private String name;
    private List<DeviceComponent> components = new ArrayList<>();

    public DeviceGroup(String name) {
        this.name = name;
    }

    public void addComponent(DeviceComponent component) {
        components.add(component);
    }

    public void removeComponent(DeviceComponent component) {
        components.remove(component);
    }

    @Override
    public void turnOn() {
        System.out.println(name + " grubu açılıyor...");
        for (DeviceComponent component : components) {
            component.turnOn();
        }
    }

    @Override
    public void turnOff() {
        System.out.println(name + " grubu kapanıyor...");
        for (DeviceComponent component : components) {
            component.turnOff();
        }
    }

    @Override
    public void printStatus() {
        System.out.println("[" + name + " grubu durumu]");
        for (DeviceComponent component : components) {
            component.printStatus();
        }
    }
}
