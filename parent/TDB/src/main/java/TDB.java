import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import de.behring.trainingDB.core.AddTraininigCommand;
import de.behring.trainingDB.core.AverageSpeed;
import de.behring.trainingDB.core.AverageSpeedImpl;
import de.behring.trainingDB.core.ClearAllTrainingsCommand;

import java.util.Calendar;
import java.util.Date;

/**
 * User: carsten
 * Date: Jan 24, 2010
 * Time: 11:05:40 PM
 */
public class TDB {
    private static Calendar cal=Calendar.getInstance();
    public static void main(String[] args) {
        ObjectContainer db= Db4o.openFile("/home/carsten/trainings.dbo");

        try {
           new ClearAllTrainingsCommand(db).execute();
           new AddTraininigCommand(db, makeDate(24,1,2010), 16.8, makeSeconds(1,53), new AverageSpeedImpl(8.9)).execute();
            new AddTraininigCommand(db, makeDate(25,1,2010), 5.3, makeSeconds(0,34,54), AverageSpeed.UNKNOWN).execute();
            new AddTraininigCommand(db, makeDate(28,1,2010), 5.3, makeSeconds(0,32,04), AverageSpeed.UNKNOWN).execute();
            new AddTraininigCommand(db, makeDate(29,1,2010), 5.3, makeSeconds(0,32,20), AverageSpeed.UNKNOWN).execute();
            new AddTraininigCommand(db, makeDate(30,1,2010), 13.2, makeSeconds(1,26), AverageSpeed.UNKNOWN).execute();

        } finally {
            db.close();
        }
    }

    /**
     *
     * @param year
     * @param month  1-based, january is 1
     * @param day
     * @return
     */
    private static Date makeDate(int year, int month, int day) {
        cal.clear();
        cal.set(year,month-1,day);
        return cal.getTime();
    }
    private static int makeSeconds(int hours, int minutes, int seconds) {
        return hours*3600 + minutes * 60 + seconds;
    }
    private static int makeSeconds(int hours, int minutes) {
        return makeSeconds(hours,minutes,0);
    }

}
