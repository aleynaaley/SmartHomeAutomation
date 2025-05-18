package controllers;

import devices.Device;
//import scenarios.Scenario;
import java.util.ArrayList;
import java.util.List;

/**
 * SmartHomeController sınıfı, akıllı ev sisteminin merkezî kontrol noktasıdır.
 * Singleton tasarım deseni ile sadece bir örneği oluşturulur ve bu örnek üzerinden cihazlar yönetilir.
 */
public class SmartHomeController {

    // SmartHomeController sınıfının tek örneğini tutacak statik değişken
    private static SmartHomeController instance;

    // Sisteme bağlı cihazların listesi
    private List<Device> devices = new ArrayList<>();

    // Yapıcı metod private tanımlanır çünkü dışarıdan doğrudan bu sınıftan nesne oluşturulmasını istemiyoruz.
    private SmartHomeController() {
        System.out.println("SmartHomeController başlatıldı.");
    }

    /**
     * Bu metod sınıfın tek örneğine erişim sağlar.
     * Eğer daha önce oluşturulmamışsa bir kereye mahsus oluşturur ve hep aynı örneği döner.
     *
     * @return SmartHomeController örneği
     */
    public static SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }

    /**
     * Sisteme yeni bir cihaz eklemek için kullanılır.
     * Örnek: yeni bir ışık, klima, kamera vs.
     *
     * @param device Sisteme eklenmek istenen cihaz
     */
    public void addDevice(Device device) {
        devices.add(device);
        System.out.println(device.getName() + " sisteme eklendi.");
    }
     
    /**
     * Sistemdeki cihazların listesini döner.
     * Bu metod, diğer bileşenlerin cihazlara erişmesini sağlar.
     *
     * @return Cihaz listesi
     */
    public List<Device> getDevices() {
        return devices;
    }

    
    /**
     * Sistemdeki tüm cihazları açar.
     */
    public void turnOnAllDevices() {
        for (Device device : devices) {
            device.turnOn();
        }
    }

      /**
     * Sistemdeki tüm cihazları kapatır.
     */
    public void turnOffAllDevices() {
        for (Device device : devices) {
            device.turnOff();
        }
    }

    /**
     * Sistemdeki tüm cihazların durumlarını listeler.
     */
    public void printAllDeviceStatus() {
        for (Device device : devices) {
            System.out.println(device.getClass().getSimpleName() + " is " + (device.isOn() ? "ON" : "OFF"));
        }
    }

    /**
     * Verilen bir senaryoyu (örneğin GeceModu, TatilModu) çalıştırır.
     * Senaryo nesnesi, cihazları nasıl yöneteceğini kendi execute metodunda tanımlar.
     *
     * @param scenario Çalıştırılacak senaryo
     
    public void runScenario(Scenario scenario) {
        scenario.execute(devices);
    }
        */
}
