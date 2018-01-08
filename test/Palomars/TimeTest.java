/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Palomars;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deema
 */
public class TimeTest {
    
    public TimeTest() {
    }

    /**
     * Test of ToPalomarsTime method, of class Time.
     */
    @Test
    public void testToPalomarsTime() {
        System.out.println("ToPalomarsTime");
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        int expResult = 31;
        int result = Time.ToPalomarsTime(time);
        assertEquals(expResult, result);
    }
    
}
