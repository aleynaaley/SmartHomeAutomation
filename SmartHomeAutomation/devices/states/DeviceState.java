package devices.states;

import devices.Device;

/**
 * DeviceState arayüzü, bir cihazın sahip olabileceği durumları (açık, kapalı, bakımda vb.) tanımlar.
 * State tasarım deseninin temelini oluşturur.
 */
public interface DeviceState {

    /**
     * Cihazı açmak için davranış tanımlar.
     *
     * @param device Hedef cihaz
     */
    void turnOn(Device device);

    /**
     * Cihazı kapatmak için davranış tanımlar.
     *
     * @param device Hedef cihaz
     */
    void turnOff(Device device);

    /**
     * Cihazın mevcut durumunun adını döner (örn. ON, OFF).
     *
     * @return Durum adı (String)
     */
    String getStateName();
}
