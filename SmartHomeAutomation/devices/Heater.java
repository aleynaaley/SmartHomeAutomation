public package devices;

/**
 * Heater sınıfı, akıllı ev sistemine entegre edilebilecek bir ısıtıcı cihazını temsil eder.
 * Bu sınıf, Device soyut sınıfından türetilmiştir.
 */
public class Heater extends Device {

    // Isıtıcının mevcut sıcaklık değeri
    private int temperature;

    /**
     * Isıtıcı oluşturulurken cihaz ismi belirtilir.
     *
     * @param name Isıtıcının ismi
     */
    public Heater(String name) {
        super(name);
        this.temperature = 20; // Varsayılan sıcaklık
    }

    /**
     * Isıtıcıyı açar ve konsola bilgi verir.
     */
    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println(getName() + " is turned ON. Current temperature: " + temperature + "°C");
        } else {
            System.out.println(getName() + " is already ON.");
        }
    }

    /**
     * Isıtıcıyı kapatır ve konsola bilgi verir.
     */
    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println(getName() + " is turned OFF.");
        } else {
            System.out.println(getName() + " is already OFF.");
        }
    }

    /**
     * Isıtıcının sıcaklığını ayarlar.
     *
     * @param temperature Ayarlanacak sıcaklık değeri
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println(getName() + " temperature set to " + temperature + "°C.");
    }

    /**
     * Isıtıcının mevcut sıcaklık değerini döner.
     *
     * @return Sıcaklık değeri
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Isıtıcının durumunu konsola yazdırır.
     */
    public void getStatus() {
        String status = isOn ? "ON" : "OFF";
        System.out.println(getName() + " is " + status + " | Temperature: " + temperature + "°C");
    }
}
 Main {
    
}
