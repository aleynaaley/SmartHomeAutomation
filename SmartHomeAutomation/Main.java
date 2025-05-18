import controllers.SmartHomeController;
import devices.Heater;
import devices.Light;

public class Main {
    public static void main(String[] args) {
            // Tekil SmartHomeController nesnesi alınır
    SmartHomeController controller = SmartHomeController.getInstance();

    // Cihazlar oluşturulur
    Light livingRoomLight = new Light("Living Room Light");
    Heater bedroomHeater = new Heater("Bedroom Heater");

    // Cihazlar sisteme eklenir
    controller.addDevice(livingRoomLight);
    controller.addDevice(bedroomHeater);

    // Tüm cihazların durumu yazdırılır (başlangıçta kapalı olmalı)
    System.out.println("\nBaşlangıç durumu:");
    controller.printAllDeviceStatus();

    // Tüm cihazlar açılır
    System.out.println("\nTüm cihazlar açılıyor:");
    controller.turnOnAllDevices();

    // Işığı tekrar açmayı dene (zaten açık)
    System.out.println("\nIşık tekrar açılmaya çalışılıyor:");
    livingRoomLight.turnOn();

    // Isıtıcının sıcaklığı ayarlanır
    bedroomHeater.setTemperature(24);

    // Durum tekrar yazdırılır
    System.out.println("\nGüncel durumlar:");
    controller.printAllDeviceStatus();

    // Tüm cihazlar kapatılır
    System.out.println("\nTüm cihazlar kapatılıyor:");
    controller.turnOffAllDevices();

    // Son durum yazdırılır
    System.out.println("\nFinal durum:");
    controller.printAllDeviceStatus();
}

    
