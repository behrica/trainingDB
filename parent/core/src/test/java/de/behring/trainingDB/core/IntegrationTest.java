package de.behring.trainingDB.core;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import org.jintegration.AbstractIntegrationTest;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * User: carsten
 * Date: Jan 24, 2010
 * Time: 7:07:09 PM
 */
public class IntegrationTest extends AbstractIntegrationTest {
    @Test
    public void testAll() throws IOException {
        File dbFile=File.createTempFile("trainingDBTest","dbo");
        dbFile.deleteOnExit();

        ObjectContainer db= Db4o.openFile(dbFile.getAbsolutePath());
        
        try {
           new ClearAllTrainingsCommand(db).execute();
           new AddTraininigCommand(db, Calendar.getInstance().getTime(), 1.0, 120, new AverageSpeedImpl(9.0)).execute();
           new AddTraininigCommand(db, Calendar.getInstance().getTime(), 2.0, 300, new AverageSpeedImpl(9.0)).execute();
            printFullDb(db);
        } finally {
            db.close();
        }
        assertManualTestPassed();
    }

    private void printFullDb(ObjectContainer db) {
        ObjectSet<Training> objectSet=db.query(Training.class);
        while (objectSet.hasNext()) {
            Training training =  objectSet.next();
            System.out.println("training = " + training);
        }
    }
}
