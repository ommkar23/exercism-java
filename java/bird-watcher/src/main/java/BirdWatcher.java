
class BirdWatcher {
    private static final int[] LAST_WEEK_COUNTS = {0, 2, 5, 3, 7, 8, 4};
    private static final int BUSY_THRESHOLD = 5;
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return LAST_WEEK_COUNTS.clone();
    }

    public int getToday() {
        if (birdsPerDay.length == 0) {
            return 0;
        }
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int birdCount: birdsPerDay) {
            if (birdCount == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int sum = 0;
        int limit = Math.min(birdsPerDay.length, numberOfDays);
        for (int i = 0; i < limit; i++) {
            sum += birdsPerDay[i];
        }
        return sum;
    }

    public int getBusyDays() {
        int busyDays = 0;
        for (int birdCount: birdsPerDay) {
            if (birdCount >= BUSY_THRESHOLD) {
                busyDays++;
            }
        }
        return busyDays;
    }
}
