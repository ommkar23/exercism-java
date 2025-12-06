public class ExperimentalRemoteControlCar implements RemoteControlCar {
    
    private static final int DRIVE_UNITS = 20;
    private int distance;
    
    public void drive() {
        distance += DRIVE_UNITS;    
    }

    public int getDistanceTravelled() {
        return distance;
    }
}
