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
        calendar.set(0, 0, 1, 4, 35, 35);
        calendar.set(Calendar.MILLISECOND, 0);
        Date time = calendar.getTime();
        int expResult = 283535;
        int result = Time.ToPalomarsTime(time);
        assertEquals(expResult, result);
    }

    /**
     * Test of WithoutSeconds method, of class Time.
     */
    @Test
    public void testWithoutSeconds() {
        System.out.println("WithoutSeconds");
        int time = 283535;
        Calendar calendar = Calendar.getInstance();
        calendar.set(0, 0, 1, 4, 35, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date expResult = calendar.getTime();
        Date result = Time.WithoutSeconds(time);
        assertEquals(expResult.getTime(), result.getTime());
    }

    /**
     * Test of NormalTime method, of class Time.
     */
    @Test
    public void testNormalTime() {
        System.out.println("NormalTime");
        int number = 285959;
        Calendar calendar = Calendar.getInstance();
        calendar.set(0, 0, 1, 4, 59, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        Date expResult = calendar.getTime();
        Date result = Time.NormalTime(number);
        assertEquals(expResult.getTime(), result.getTime());
    }
}