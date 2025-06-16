package scenarios;

import controllers.SmartHomeController;
import devices.Device;
import devices.Light;
import devices.DoorLockSystem;

/**
 * Gece modu senaryosudur.
 * Eve varınca yapılacaklar senaryosu üzerinden gidilmiştir.
 * Işıkları açılır ve kilit sistemi kapatılır.
 * Isıtıcılar ve buzdolabı açık kalabilir.
 */

public class NightModeScenario extends Scenario {

    @Override
    protected void executeScenario() {
        System.out.println("\n Gece modu başlatıldı.");
        SmartHomeController controller = SmartHomeController.getInstance();

        for (Device device : controller.getDevices()) {
            if (device instanceof Light && !device.isOn()) {
                device.turnOn();
            }
        }
        for (Device device : controller.getDevices()) {
            if (device instanceof DoorLockSystem && device.isOn()) {
                device.turnOff();
            }
        }
        System.out.println("Işıklar açıldı ve kilit sistemi kapatıldı.\n");
        System.out.println("İyi akşamlar :)\n");
    }
}
