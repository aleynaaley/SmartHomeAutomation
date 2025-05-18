package devices;

/**
 * Light sınıfı, bir ışık cihazını temsil eder.
 * Device arayüzünü uygulayarak açma, kapama ve durum kontrolü özelliklerini sağlar.
 */
public class Light extends Device {

    public Light(String name) {
        super(name); // Device sınıfındaki constructor çağrılır
        this.state = new OffState(); // başlangıç durumu
    }
}
