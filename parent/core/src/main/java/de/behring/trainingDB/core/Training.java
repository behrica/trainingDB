package de.behring.trainingDB.core;

import java.util.Date;

/**
 * User: carsten
 * Date: Jan 24, 2010
 * Time: 6:42:25 PM
 */
public class Training {
    private final Date trainingDate;
    private final double km;
    private final int timeInSeconds;
    private final AverageSpeed averageSpeed;


    public Training(Date trainingDate, double km, int timeInSeconds, AverageSpeed averageSpeed) {

        this.trainingDate = trainingDate;
        this.km = km;
        this.timeInSeconds = timeInSeconds;

        this.averageSpeed = averageSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Training training = (Training) o;

        if (Double.compare(training.km, km) != 0) return false;
        if (timeInSeconds != training.timeInSeconds) return false;
        if (averageSpeed != null ? !averageSpeed.equals(training.averageSpeed) : training.averageSpeed != null)
            return false;
        if (trainingDate != null ? !trainingDate.equals(training.trainingDate) : training.trainingDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = trainingDate != null ? trainingDate.hashCode() : 0;
        temp = km != +0.0d ? Double.doubleToLongBits(km) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + timeInSeconds;
        result = 31 * result + (averageSpeed != null ? averageSpeed.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Training{" +
                "trainingDate=" + trainingDate +
                ", km=" + km +
                ", timeInSeconds=" + timeInSeconds +
                ", averageSpeed=" + averageSpeed +
                '}';
    }
}
