package devices;

import devices.states.OffState;

public class Refrigerator extends Device {

    private int temperature;

    public Refrigerator(String name) {
        super(name);
        this.state = new OffState();
        this.temperature = 4; // Varsayılan sıcaklık 4°C
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println(getName() + " temperature set to " + temperature + "°C.");
    }

    public int getTemperature() {
        return temperature;
    }

    public void getStatus() {
        String status = isOn() ? "ON" : "OFF";
        System.out.println(getName() + " is " + status + " | Temperature: " + temperature + "°C");
    }
}
