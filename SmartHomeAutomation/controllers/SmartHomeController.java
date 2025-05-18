package controllers;

import devices.Device;
import scenarios.Scenario;
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
    }

    /**
     * Sistemdeki tüm cihazları çalıştırır (turnOn() metodunu çağırır).
     * Örneğin "Tüm cihazları başlat" ya da "evdeyim modunu aktif et" gibi bir senaryo için kullanılır.
     */
    public void activateAllDevices() {
        for (Device d : devices) {
            d.turnOn(); // Her cihazın kendi turnOn() davranışı çağrılır (polimorfizm!)
        }
    }

    /**
     * Verilen bir senaryoyu (örneğin GeceModu, TatilModu) çalıştırır.
     * Senaryo nesnesi, cihazları nasıl yöneteceğini kendi execute metodunda tanımlar.
     *
     * @param scenario Çalıştırılacak senaryo
     */
    public void runScenario(Scenario scenario) {
        scenario.execute(devices);
    }
}
