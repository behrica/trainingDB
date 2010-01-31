package de.behring.trainingDB.core;

import com.db4o.ObjectContainer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.ConsoleSpammingMockitoJUnitRunner;

import java.util.Calendar;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * User: carsten
 * Date: Jan 24, 2010
 * Time: 5:45:43 PM
 */
@RunWith(ConsoleSpammingMockitoJUnitRunner.class)
public class AddTrainingCommandTest {
    @Mock private ObjectContainer  dbMock;

    @Test
    public void testExeceute() {
        Calendar cal=Calendar.getInstance();
        cal.clear();
        cal.set(2010,5,26);
        AddTraininigCommand addTraininigCommand=new AddTraininigCommand(dbMock, cal.getTime(), 20.0, 1234, new AverageSpeedImpl(9.1));
        addTraininigCommand.execute();
        verify(dbMock,times(1)).store(new Training(cal.getTime(),20.0, 1234, new AverageSpeedImpl(9.1)));
        

    }
}
