package devices;
import devices.states.OffState;
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
        this.temperature = 20;
        this.state = new OffState();
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
        String status = isOn() ? "ON" : "OFF";
        System.out.println(getName() + " is " + status + " | Temperature: " + temperature + "°C");
    }
}
 
