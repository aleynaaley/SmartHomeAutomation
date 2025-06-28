import devices.*;
import controllers.SmartHomeController;
import scenarios.*;
import composite.*;

public class Main {
    public static void main(String[] args) {
        printTitle();

        // 1. Singleton SmartHomeController örneği
        SmartHomeController controller = SmartHomeController.getInstance();

        // 2. Tekil cihazlar oluşturulur

        // Işıklar
        Light salonIsigi = new Light("Salon Işığı");
        Light mutfakIsigi = new Light("Mutfak Işığı");
        Light cocukOdasiIsigi = new Light("Çocuk Odası Işığı");
        Light calismaOdasiIsigi = new Light("Çalışma Odası Işığı");

        // Isıtıcılar
        Heater salonIsitici = new Heater("Salon Isıtıcı");
        Heater mutfakIsitici = new Heater("Mutfak Isıtıcı");
        Heater cocukOdasiIsitici = new Heater("Çocuk Odası Isıtıcı");
        Heater calismaOdasiIsitici = new Heater("Çalışma Odası Isıtıcı");

        // Buzdolapları
        Refrigerator mutfakBuzdolabi = new Refrigerator("Mutfak Buzdolabı");
        Refrigerator calismaOdasiBuzdolabi = new Refrigerator("Çalışma Odası Buzdolabı");
        Device disKapiKilidi = new DoorLockSystem("Dış Kapı Kilidi");

        // 3. Cihazlar controller'a eklenir
        controller.addDevice(salonIsigi);
        controller.addDevice(mutfakIsigi);
        controller.addDevice(cocukOdasiIsigi);
        controller.addDevice(calismaOdasiIsigi);

        controller.addDevice(salonIsitici);
        controller.addDevice(mutfakIsitici);
        controller.addDevice(cocukOdasiIsitici);
        controller.addDevice(calismaOdasiIsitici);

        controller.addDevice(mutfakBuzdolabi);
        controller.addDevice(calismaOdasiBuzdolabi);
        controller.addDevice(disKapiKilidi);

       
        // 4. Cihazlar SingleDevice olarak sarılır
        DeviceComponent salonIsigiComp = new SingleDevice(salonIsigi);
        DeviceComponent mutfakIsigiComp = new SingleDevice(mutfakIsigi);
        DeviceComponent cocukOdasiIsigiComp = new SingleDevice(cocukOdasiIsigi);
        DeviceComponent calismaOdasiIsigiComp = new SingleDevice(calismaOdasiIsigi);

        DeviceComponent salonIsiticiComp = new SingleDevice(salonIsitici);
        DeviceComponent mutfakIsiticiComp = new SingleDevice(mutfakIsitici);
        DeviceComponent cocukOdasiIsiticiComp = new SingleDevice(cocukOdasiIsitici);
        DeviceComponent calismaOdasiIsiticiComp = new SingleDevice(calismaOdasiIsitici);

        DeviceComponent mutfakBuzdolabiComp = new SingleDevice(mutfakBuzdolabi);
        DeviceComponent calismaOdasiBuzdolabiComp = new SingleDevice(calismaOdasiBuzdolabi);
        DeviceComponent kilitComp = new SingleDevice(disKapiKilidi);

        // 5. Gruplar oluşturulur

        // Işık grupları
        DeviceGroup isikGrubu = new DeviceGroup("Işıklar Grubu");
        isikGrubu.addComponent(salonIsigiComp);
        isikGrubu.addComponent(mutfakIsigiComp);
        isikGrubu.addComponent(cocukOdasiIsigiComp);
        isikGrubu.addComponent(calismaOdasiIsigiComp);

        // Isıtıcı grupları
        DeviceGroup isiticiGrubu = new DeviceGroup("Isıtıcılar Grubu");
        isiticiGrubu.addComponent(salonIsiticiComp);
        isiticiGrubu.addComponent(mutfakIsiticiComp);
        isiticiGrubu.addComponent(cocukOdasiIsiticiComp);
        isiticiGrubu.addComponent(calismaOdasiIsiticiComp);

        // Buzdolabı grubu
        DeviceGroup buzdolabiGrubu = new DeviceGroup("Buzdolapları Grubu");
        buzdolabiGrubu.addComponent(mutfakBuzdolabiComp);
        buzdolabiGrubu.addComponent(calismaOdasiBuzdolabiComp);

        // Kilit sistemi grubu
        DeviceGroup kilitGrubu = new DeviceGroup("kilit sistemleri Grubu");
        kilitGrubu.addComponent(kilitComp);

        // 6. Ana grup oluşturulur
        DeviceGroup tumCihazlar = new DeviceGroup("Tüm Cihazlar Grubu");
        tumCihazlar.addComponent(isikGrubu);
        tumCihazlar.addComponent(isiticiGrubu);
        tumCihazlar.addComponent(buzdolabiGrubu);
        tumCihazlar.addComponent(kilitGrubu);

        // 7. Testler - açma kapama işlemleri

        System.out.println("\n--- Tüm cihazlar açılıyor ---");
        tumCihazlar.turnOn();
        controller.printAllDeviceStatus();

        System.out.println("\n--- Işıklar kapatılıyor ---");
        isikGrubu.turnOff();
        controller.printAllDeviceStatus();

        System.out.println("\n---Çocuk odası ışığı dışında tüm odaların ışıkları açılsın ---");
        // Çocuk odası ışığı kapalı kalsın, diğer ışıklar açık olsun
        salonIsigi.turnOn();
        mutfakIsigi.turnOn();
        calismaOdasiIsigi.turnOn();
        controller.printAllDeviceStatus();

        System.out.println("\n--- Isıtıcılar kapatılıyor ---");
        isiticiGrubu.turnOff();
        controller.printAllDeviceStatus();

        System.out.println("\n--- Mutfak buzdolabı kapatılamaz, çalışma odası buzdolabı kapatılıyor ---");
        mutfakBuzdolabi.turnOn();  // Buzdolabı genelde açık kalır
        calismaOdasiBuzdolabi.turnOff();
        controller.printAllDeviceStatus();

        //Vacation Mode çalıştır
        System.out.println("\n[Senaryo] Tatil Modu Aktif Ediliyor...");
        VacationModeScenario vacationMode = new VacationModeScenario();
        vacationMode.run();

        System.out.println("\n--- Tatil Modu Sonrası Durum ---");
        controller.printAllDeviceStatus();

        //return vocation mode çalıştır
        System.out.println("\n[Senaryo] Tatil Dönüşü Modu Aktif Ediliyor...");
        ReturnVacationModeScenario returnvacationMode = new ReturnVacationModeScenario();
        returnvacationMode.run();

        System.out.println("\n--- Tatil Dönüşü Modu Sonrası Durum ---");
        controller.printAllDeviceStatus();

        //Night mode çalıştır
        System.out.println("\n[Senaryo] Night Modu Aktif Ediliyor...");
        NightModeScenario nightMode = new NightModeScenario();
        nightMode.run();

        System.out.println("\n--- Night Modu Sonrası Durum ---");
        controller.printAllDeviceStatus();
        
    }
    
    public static void printTitle() {
        System.out.println("\033[32m");
        System.out.println("_________                      __      ___ ___                            _____          __                         __  .__               ");
        System.out.println("/   _____/ _____ _____ ________/  |_   /   |   \\  ____   _____   ____     /  _  \\  __ ___/  |_  ____   _____ _____ _/  |_|__| ____   ____  ");
        System.out.println("\\_____  \\ /     \\\\__  \\\\_  __ \\   __\\ /    ~    \\/  _ \\ /     \\_/ __ \\   /  /_\\  \\|  |  \\   __\\/  _ \\ /     \\\\__  \\\\   __\\  |/  _ \\ /    \\ ");
        System.out.println("/        \\  Y Y  \\/ __ \\|  | \\/|  |   \\    Y    (  <_> )  Y Y  \\  ___/  /    |    \\  |  /|  | (  <_> )  Y Y  \\/ __ \\|  | |  (  <_> )   |  \\");
        System.out.println("/_______  /__|_|  (____  /__|   |__|    \\___|_  / \\____/|__|_|  /\\___  > \\____|__  /____/ |__|  \\____/|__|_|  (____  /__| |__\\____/|___|  /");
        System.out.println("        \\/      \\/     \\/                     \\/              \\/     \\/          \\/                         \\/     \\/                    \\/");
        System.out.println("\033[0m");
    }
}

