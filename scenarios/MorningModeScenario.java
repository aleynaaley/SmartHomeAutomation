package scenarios;

import controllers.SmartHomeController;
import devices.Device;
import devices.Light;

/**
 * Sabah modu senaryosudur.
 * Işıkları açar,tüm ısıtıcılar açık kalabilir.
 */
public class MorningModeScenario extends Scenario {

    @Override
    protected void executeScenario() {
        System.out.println("\n Sabah modu başlatıldı.");
        SmartHomeController controller = SmartHomeController.getInstance();

        for (Device device : controller.getDevices()) {
            if (device instanceof Light && !device.isOn()) {
                device.turnOn();
            }
        }

        System.out.println("Işıklar açıldı.\n");
        System.out.println("Gunaydın :)\n");
    }
}
