package de.behring.trainingDB.core;

public class AverageSpeedImpl implements AverageSpeed {

   
    private final double averageSpeed;

    public AverageSpeedImpl(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    @Override
    public double getAverageSpeed() {
        return averageSpeed;
    }



    @Override
    public String toString() {
        return "AverageSpeedImpl{" +
                "averageSpeed=" + averageSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AverageSpeedImpl that = (AverageSpeedImpl) o;

        if (Double.compare(that.averageSpeed, averageSpeed) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        long temp = averageSpeed != +0.0d ? Double.doubleToLongBits(averageSpeed) : 0L;
        return (int) (temp ^ (temp >>> 32));
    }


}
