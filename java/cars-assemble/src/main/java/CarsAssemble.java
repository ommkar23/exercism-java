
public class CarsAssemble {

    private static final int BASE_CARS_PER_HOUR = 221;

    public double productionRatePerHour(int speed) {
        double success_rate;
        if (speed <= 4) {
            success_rate = 1.0;
        } else if (speed <= 8) {
            success_rate = 0.9;
        } else if (speed <= 9) {
            success_rate = 0.8;
        } else {
            success_rate = 0.77;
        }
        return speed * BASE_CARS_PER_HOUR * success_rate;
    }

    public int workingItemsPerMinute(int speed) {
        return (int)(productionRatePerHour(speed) / 60.0);
    }
}
