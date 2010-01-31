package de.behring.trainingDB.core;

/**
 * User: carsten
 * Date: Jan 31, 2010
 * Time: 11:28:11 PM
 */
public interface AverageSpeed {
     public static final AverageSpeed UNKNOWN=new UnknownAverage();
    double getAverageSpeed();


     static class UnknownAverage implements AverageSpeed {

        @Override
        public double getAverageSpeed() {
            return 0;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }
}
