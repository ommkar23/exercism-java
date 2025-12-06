public class JedliksToyCar {
    private static final int DISTANCE_IN_ONE_DRIVE = 20;
    private static final int FULL_BATTERY_PERCENTAGE = 100;
    private int distanceDriven;

    private int calculateBattery() {
        return FULL_BATTERY_PERCENTAGE - distanceDriven / DISTANCE_IN_ONE_DRIVE;
    }

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return "Driven %d meters".formatted(distanceDriven);    
    }

    public String batteryDisplay() {
        return calculateBattery() == 0 ?
            "Battery empty" :
            "Battery at %d%%".formatted(calculateBattery());
    }

    public void drive() {
        if (calculateBattery() > 0) {
            distanceDriven += DISTANCE_IN_ONE_DRIVE;
        }
    }
}
