class NeedForSpeed {
    private static final int MAX_BATTERY_PERCENT = 100;
    
    private final int speed;
    private final int batteryDrain;
    
    private int distance;
    // Track battery state separate from distance
    // Helps avoid coupling battery to distance
    // Updating distance logic may change in future e.g. in 
    // coasting or regen mode
    private int battery;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.battery = MAX_BATTERY_PERCENT;
    }

    public boolean batteryDrained() {
        return battery < batteryDrain;
    }

    public int distanceDriven() {
        return this.distance;
    }

    public void drive() {
        if (!batteryDrained()) {
            this.distance += this.speed;
            this.battery -= batteryDrain;
            
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }

    public boolean canDrive(int distance) {
        return distance <= speed * battery / batteryDrain;
    }
}

class RaceTrack {
    private final int distance;
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        return car.canDrive(distance);
    }
}
