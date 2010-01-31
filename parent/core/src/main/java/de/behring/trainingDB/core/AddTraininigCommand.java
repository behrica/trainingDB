package de.behring.trainingDB.core;

import com.db4o.ObjectContainer;

import java.util.Date;

/**
 * User: carsten
 * Date: Jan 24, 2010
 * Time: 5:47:16 PM
 */
public class AddTraininigCommand extends AbstractCommand {

    private final Training training;

    public AddTraininigCommand(ObjectContainer container, Date trainingDate, double km, int timeInSeconds, AverageSpeed averageSpeed) {
       super(container);
        this.training=new Training(trainingDate,km, timeInSeconds, averageSpeed);

    }


    @Override
    public void executeInObjectContainer(ObjectContainer objectContainer) {
        objectContainer.store(training);
    }
}
