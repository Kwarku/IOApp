package pl.narodzinyprogramisty;

public class Weather {
    private int minTemp;
    private int maxTemp;
    private int meanTemp;

    public Weather(int minTemp, int maxTemp, int meanTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.meanTemp = meanTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMeanTemp() {
        return meanTemp;
    }

    public void setMeanTemp(int meanTemp) {
        this.meanTemp = meanTemp;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", meanTemp=" + meanTemp +
                '}';
    }
}
