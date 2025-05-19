package scenarios;

import controllers.SmartHomeController;
import devices.Device;
import devices.Light;

/**
 * Gece modu senaryosudur.
 * Işıkları kapatır,tüm ısıtıcılar açık kalabilir.
 */
public class NightModeScenario extends Scenario {

    @Override
    protected void executeScenario() {
        System.out.println("\nGece modu başlatıldı.");
        SmartHomeController controller = SmartHomeController.getInstance();

        for (Device device : controller.getDevices()) {
            if (device instanceof Light && device.isOn()) {
                device.turnOff();
            }
        }

        System.out.println("Işıklar kapatıldı.\n");
        System.out.println("İyi uykular :)\n");
    }
}
