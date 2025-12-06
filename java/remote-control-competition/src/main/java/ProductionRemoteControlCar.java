public class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private static final int DRIVE_UNITS = 10;
    private int distance;
    private int victories;

    public void drive() {
        distance += DRIVE_UNITS;    
    }

    public int getDistanceTravelled() {
        return distance;
    }

    public int getNumberOfVictories() {
        return victories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        victories = numberOfVictories;
    }

    public int compareTo(ProductionRemoteControlCar car) {
        return victories < car.getNumberOfVictories() ? -1 : victories > car.getNumberOfVictories() ? 1 : 0;
    }
}
