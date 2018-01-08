/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deema
 * Тестирование класса для работы со временем.
 */
public class TimeTest {
    
    public TimeTest() {
    }

    /**
     * Test of IntDateTime method, of class TimeHelper.
     */
    @Test
    public void testIntDateTime() {
        System.out.println("IntDateTime");
        Calendar cl = Calendar.getInstance();
        cl.set(2017, 11, 1, 0, 0, 0);
        Date input = cl.getTime();
        int expResult = 20171201;
        int result = TimeHelper.IntDateTime(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of NormalDateTime method, of class TimeHelper.
     */
    @Test
    public void testNormalDateTime() {
        System.out.println("NormalDateTime");
        Calendar cl = Calendar.getInstance();
        cl.set(2017, 11, 1, 0, 0, 0);
        cl.set(Calendar.MILLISECOND, 0);
        int input = 20171201;
        Date expResult = cl.getTime();
        Date result = TimeHelper.NormalDateTime(input);
        assertEquals(expResult.getTime(), result.getTime());
    }   

    /**
     * Test of GetDaysByActualYear method, of class TimeHelper.
     */
    @Test
    public void testGetDaysByActualYear() {
        System.out.println("GetDaysByActualYear");
        int expResult = 365;
        ArrayList<Integer> result = TimeHelper.GetDaysByActualYear();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of GetSignificantMinuts method, of class TimeHelper.
     */
    @Test
    public void testGetSignificantMinuts() {
        System.out.println("GetSignificantMinuts");
        int inputDur = 90;
        int expResult = 120;
        int result = TimeHelper.GetSignificantMinuts(inputDur);
        assertEquals(expResult, result);
        inputDur = 15;
        expResult = 60;
        result = TimeHelper.GetSignificantMinuts(inputDur);
        assertEquals(expResult, result);
        short inputShortDur = 35;
        expResult = 60;
        result = TimeHelper.GetSignificantMinuts(inputShortDur);
        assertEquals(expResult, result);
    }
}
