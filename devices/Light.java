package devices;

/**
 * Light sınıfı, bir ışık cihazını temsil eder.
 * Device arayüzünü uygulayarak açma, kapama ve durum kontrolü özelliklerini sağlar.
 */
public class Light implements Device {

    // Işığın açık/kapalı durumunu tutan değişken
    private boolean isOn;

    /**
     * Light nesnesi oluşturulduğunda başlangıçta kapalı (false) durumdadır.
     */
    public Light() {
        this.isOn = false;
    }

    /**
     * Işığı açar.
     * Eğer ışık zaten açıksa, tekrar açılmaz.
     */
    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Light is turned ON.");
        } else {
            System.out.println("Light is already ON.");
        }
    }

    /**
     * Işığı kapatır.
     * Eğer ışık zaten kapalıysa, tekrar kapatılmaz.
     */
    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Light is turned OFF.");
        } else {
            System.out.println("Light is already OFF.");
        }
    }

    /**
     * Işığın açık mı kapalı mı olduğunu döner.
     *
     * @return true ise ışık açık, false ise kapalıdır.
     */
    @Override
    public boolean isOn() {
        return isOn;
    }
}
