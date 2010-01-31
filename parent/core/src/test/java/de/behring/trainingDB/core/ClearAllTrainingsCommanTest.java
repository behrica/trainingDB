package de.behring.trainingDB.core;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.ConsoleSpammingMockitoJUnitRunner;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.anything;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;                           

/**
 * User: carsten
 * Date: Jan 24, 2010
 * Time: 7:13:55 PM
 */
@RunWith(ConsoleSpammingMockitoJUnitRunner.class)
public class ClearAllTrainingsCommanTest {
     @Mock
     private ObjectContainer dbMock;

    @Mock private ObjectSet<Training> objectSetMock;

    @Test
    public void test() {
        Calendar cal=Calendar.getInstance();
        cal.clear();
        cal.set(2010,5,26);

         Training tr1 = new Training(cal.getTime(),1.0, 120, new AverageSpeedImpl(2.0));
        cal.set(2010,1,20);
        Training tr2 = new Training(cal.getTime(),10.0, 120, new AverageSpeedImpl(20.0));



        ClearAllTrainingsCommand command=new ClearAllTrainingsCommand(dbMock);

        when(dbMock.query(Training.class)).thenReturn(objectSetMock);
        when(objectSetMock.hasNext()).thenReturn(true,true,false);
        when(objectSetMock.next()).thenReturn(tr1,tr2);
        command.execute();
        verify(dbMock,times(1)).query(Training.class);
        verify(dbMock,times(1)).delete(tr1);
        verify(dbMock,times(1)).delete(tr2);


    }
}
