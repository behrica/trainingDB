package de.behring.trainingDB.core;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: carsten
 * Date: Jan 24, 2010
 * Time: 7:57:35 PM
 */
public class TrainingTest {
    @Test
    public void testEquals_hashCode() throws Exception {
         Calendar cal=Calendar.getInstance();
        cal.clear();
        cal.set(2010,5,26);

         Training tr1 = new Training(cal.getTime(),1.0, 60, new AverageSpeedImpl(2.0));
        Training tr2 = new Training(cal.getTime(),1.0, 60,new AverageSpeedImpl(2.0));
        
         cal.set(2010,1,20);
        Training tr3 = new Training(cal.getTime(),10.0, 120, new AverageSpeedImpl(20.0));

        assertThat(tr1.equals(tr1),is(true));
        assertThat(tr1.equals(tr2),is(true));
        assertThat(tr2.equals(tr1),is(true));
        assertThat(tr2.equals(tr3),is(false));
        assertThat(tr1.equals(tr3),is(false));

        assertThat(tr1.hashCode(),is(tr2.hashCode()));
    }

}
