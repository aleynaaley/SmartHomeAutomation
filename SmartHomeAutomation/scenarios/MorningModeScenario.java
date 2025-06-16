package scenarios;

import controllers.SmartHomeController;
import devices.Device;
import devices.Light;

/**
 * Sabah modu senaryosudur.
 * Işıkları kapanır ,tüm ısıtıcılar ve kilit sistemi açık kalabilir.
 */

public class MorningModeScenario extends Scenario {

    @Override
    protected void executeScenario() {
        System.out.println("\n Sabah modu başlatıldı.");
        SmartHomeController controller = SmartHomeController.getInstance();

        for (Device device : controller.getDevices()) {
            if (device instanceof Light && device.isOn()) {
                device.turnOff();
            }
        }

        System.out.println("Işıklar Kapatıldı.\n");
    }
}
