package scenarios;

import controllers.SmartHomeController;
import devices.Device;

/**
 * Tatil modu senaryosudur.
 * Tüm cihazları kapatır.
 */
public class VacationModeScenario extends Scenario {

    @Override
    protected void executeScenario() {
        System.out.println("\nTatil modu başlatıldı.");
        SmartHomeController controller = SmartHomeController.getInstance();

        for (Device device : controller.getDevices()) {
            if (device.isOn()) {
                device.turnOff();
            }
        }

        System.out.println("Tüm cihazlar kapatıldı. Güvenli tatil modu aktif.\n");
        System.out.println("İyi tatiller:)\n");
    }
}
