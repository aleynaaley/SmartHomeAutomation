package devices;

import devices.states.OffState;

public class DoorLockSystem extends Device {

    public DoorLockSystem(String name) {
        super(name);
        this.state = new OffState(); 
    }

    @Override
    public void turnOn() {
        // Unlock the door
        if (!isOn()) {
            state.turnOn(this);
            System.out.println(getName() + " is now unlocked.");
        }
    }

    @Override
    public void turnOff() {
        // Lock the door
        if (isOn()) {
            state.turnOff(this);
            System.out.println(getName() + " is now locked.");
        }
    }

    public void getStatus() {
        String status = isOn() ? "Unlocked" : "Locked";
        System.out.println(getName() + " is currently " + status + ".");
    }
}
