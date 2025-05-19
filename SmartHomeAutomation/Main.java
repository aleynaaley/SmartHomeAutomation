import composite.DeviceComponent;
import composite.DeviceGroup;
import composite.SingleDevice;
import controllers.SmartHomeController;
import devices.Heater;
import devices.Light;

public class Main {
    public static void main(String[] args) {
        printTitle();
        // 1. SmartHomeController örneği alınır (Singleton)
        SmartHomeController controller = SmartHomeController.getInstance();

        // 2. Tekil cihazlar oluşturulur
        Light salonIsigi = new Light("Salon Işığı");
        Light mutfakIsigi = new Light("Mutfak Işığı");
        Heater yatakOdaIsitici = new Heater("Yatak Odası Isıtıcı");

        // 3. Cihazlar controller'a eklenir (standart kayıt)
        controller.addDevice(salonIsigi);
        controller.addDevice(mutfakIsigi);
        controller.addDevice(yatakOdaIsitici);

        // 4. Cihazlar Composite SingleDevice yapısına sarılır
        DeviceComponent salonIsigiComp = new SingleDevice(salonIsigi);
        DeviceComponent mutfakIsigiComp = new SingleDevice(mutfakIsigi);
        DeviceComponent isiticiComp = new SingleDevice(yatakOdaIsitici);

        // 5. Işıklar grubu oluşturulur ve ışıklar eklenir
        DeviceGroup isikGrubu = new DeviceGroup("Işıklar Grubu");
        isikGrubu.addComponent(salonIsigiComp);
        isikGrubu.addComponent(mutfakIsigiComp);

        // 6. Isıtıcı grubu oluşturulur
        DeviceGroup isiticiGrubu = new DeviceGroup("Isıtıcı Grubu");
        isiticiGrubu.addComponent(isiticiComp);

        // 7. Tüm cihazlar için ana grup oluşturulur (nested composite)
        DeviceGroup tumCihazlar = new DeviceGroup("Tüm Cihazlar Grubu");
        tumCihazlar.addComponent(isikGrubu);
        tumCihazlar.addComponent(isiticiGrubu);

        // 8. Composite testleri

        // Tüm cihazları aç
        System.out.println("\n--- Tüm cihazlar açılıyor (Composite turnOn) ---");
        tumCihazlar.turnOn();

        // Tüm cihazların durumunu yazdır
        System.out.println("\n--- Tüm cihaz durumları (SmartHomeController) ---");
        controller.printAllDeviceStatus();

        // Sadece ışık grubunu kapat
        System.out.println("\n--- Sadece ışık grubu kapatılıyor ---");
        isikGrubu.turnOff();

        // Tekil cihazı doğrudan kapat (SingleDevice örneği)
        System.out.println("\n--- Yatak Odası Isıtıcı doğrudan kapatılıyor ---");
        isiticiComp.turnOff();

        // Final durumu yazdır
        System.out.println("\n--- Final durum ---");
        controller.printAllDeviceStatus();
    }

    public static void printTitle() {
        System.out.println("\033[33m"); // Sarı renk
        System.out.println("  ___    ");
        System.out.println(" / ______   ");
        System.out.println(" \\__\\  ");
        System.out.println(" | ");
        System.out.println("|");
        System.out.println("\033[0m"); // Renk sıfırlama
    }
}
