package de.behring.trainingDB.core;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.Calendar;
import java.util.Date;

/**
 * User: carsten
 * Date: Jan 24, 2010
 * Time: 7:15:13 PM
 */
public class ClearAllTrainingsCommand extends AbstractCommand{


    public ClearAllTrainingsCommand(ObjectContainer objectContainer) {
        super(objectContainer);
    }

    @Override
    public void executeInObjectContainer(ObjectContainer objectContainer) {
        ObjectSet<Training> trainings=objectContainer.query(Training.class);
        while(trainings.hasNext()) {
            objectContainer.delete(trainings.next());
        }
    }
}
