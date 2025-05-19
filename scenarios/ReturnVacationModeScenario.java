package scenarios;

import controllers.SmartHomeController;
import devices.Device;

/**
 * Tatil dönüş modu senaryosudur.
 * Tüm cihazları açılır.
 */
public class ReturnVacationModeScenario extends Scenario {

    @Override
    protected void executeScenario() {
        System.out.println("\nTatil dönüş modu başlatıldı.");
        SmartHomeController controller = SmartHomeController.getInstance();

        for (Device device : controller.getDevices()) {
            if (!device.isOn()) {
                device.turnOn();
            }
        }

        System.out.println("Tüm cihazlar açıldı.\n");
        System.out.println("Evinize Hoşgeldiniz :)\n");
    }
}
