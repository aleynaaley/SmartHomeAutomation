package devices;

/**
 * Device arayüzü, akıllı ev sistemindeki tüm cihazların ortak davranışlarını tanımlar.
 * Her cihaz açılabilir (turnOn) ve kapatılabilir (turnOff).
 * Ayrıca, cihazın açık olup olmadığını sorgulamak için isOn() metodu bulunur.
 */
public interface Device {

    /**
     * Cihazı açmak için çağrılır.
     * Örneğin, ışıklar için lambayı yakar, klima için çalışmayı başlatır.
     */
    void turnOn();

    /**
     * Cihazı kapatmak için çağrılır.
     * Örneğin, ışıklar için lambayı söndürür, klima için durdurur.
     */
    void turnOff();

    /**
     * Cihazın açık mı kapalı mı olduğunu döner.
     * 
     * @return true ise cihaz açık, false ise kapalıdır.
     */
    boolean isOn();
}
