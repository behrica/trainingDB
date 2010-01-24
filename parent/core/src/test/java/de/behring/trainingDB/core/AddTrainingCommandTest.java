package de.behring.trainingDB.core;

import org.junit.Test;

import java.util.Calendar;

/**
 * User: carsten
 * Date: Jan 24, 2010
 * Time: 5:45:43 PM
 */
public class AddTrainingCommandTest {
    @Test
    public void testExeceute() {
        Calendar cal=Calendar.getInstance();
        cal.clear();
        cal.set(2010,5,26);
        AddTraininigCommand addTraininigCommand=new AddTraininigCommand(cal.getTime(),20,9.1);
        addTraininigCommand.execute();

    }
}
