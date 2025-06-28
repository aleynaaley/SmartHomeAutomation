package controllers;

import devices.Device;
import composite.DeviceComponent;
import java.util.ArrayList;
import java.util.List;

/**
 * SmartHomeController sınıfı, akıllı ev sisteminin kontrol noktasıdır.
 * Singleton tasarım deseni ile sadece bir örneği oluşturulur ve bu örnek üzerinden cihazlar yönetilir.
 */

public class SmartHomeController {

    // SmartHomeController sınıfının tek örneğini tutacak statik değişken
    private static SmartHomeController instance;

    // Bireysel cihazların listesi
    private List<Device> devices = new ArrayList<>();

    // Cihaz gruplarını (Composite yapıları) tutan liste
    private List<DeviceComponent> deviceGroups = new ArrayList<>();

    // Yapıcı metod private, dışarıdan örnek alınamaz
    private SmartHomeController() {
        System.out.println("SmartHomeController başlatıldı.");
    }

    /**
     * Singleton desenine uygun olarak tek örneği döner
     */

    public static SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }

    /**
     * Yeni bir cihazı sisteme ekler
     */

    public void addDevice(Device device) {
        devices.add(device);
        System.out.println(device.getName() + " sisteme eklendi.");
    }

    /**
     * İsimle cihaz arama işlemi yapar
     */

    public Device getDeviceByName(String name) {
        for (Device device : devices) {
            if (device.getName().equalsIgnoreCase(name)) {
                return device;
            }
        }
        return null;
    }

    /**
     * Tüm bireysel cihazların listesini döner
     */
    
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * Yeni bir cihaz grubunu (Composite) ekler
     */

    public void addDeviceGroup(DeviceComponent group) {
        deviceGroups.add(group);
    }

    /**
     * Cihaz gruplarının (Composite) listesini döner
     */

    public List<DeviceComponent> getDeviceGroups() {
        return deviceGroups;
    }

    /**
     * Tüm bireysel cihazları açar
     */

    public void turnOnAllDevices() {
        for (Device device : devices) {
            device.turnOn();
        }
    }

    /**
     * Tüm bireysel cihazları kapatır
     */

    public void turnOffAllDevices() {
        for (Device device : devices) {
            device.turnOff();
        }
    }

    /**
     * Tüm cihazların durumunu konsola yazdırır
     */
    
    public void printAllDeviceStatus() {
        for (Device device : devices) {
            System.out.println(device.getClass().getSimpleName() + " is " + (device.isOn() ? "ON" : "OFF"));
        }
    }
}
