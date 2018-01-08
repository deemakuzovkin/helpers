/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author deema Класс для работы с датой и временем.
 */
public class Time {

    public Time() {
    }

    /**
     * Актуальный календарь.
     */
    public static Calendar calendar = Calendar.getInstance();

    /**
     * Текущая дата и время.
     */
    public static final Date Now = calendar.getTime();

    /**
     * Преобразовать дату из нормального формата в числовой (yyyyMMdd).
     * 
     * @param input Дата в нормальном формате. 
     * @return Реузультат.
     */
    public static int IntDateTime(Date input) {
        int result = 0;
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateFormat = sDateFormat.format(input);
        result = Integer.parseInt(dateFormat);
        return result;
    }

    /**
     * Преобразование даты из числового формата (yyyyMMdd), к нормальному виду.
     * 
     * @param input Дата в числовом формате. 
     * @return Результат.
     */
    public static Date NormalDateTime(int input) {
        Calendar cl = Calendar.getInstance();
        if (input <= 0) {
            return null;
        }
        String inputString = String.valueOf(input);
        if (inputString.length() < 8) {
            return null;
        }
        int d = input % 100;
        if (d <= 0 || d > 31) {
            return null;
        }
        int m = (input / 100) % 100;
        if (m <= 0 || m > 12) {
            return null;
        }
        int y = input / 10000;
        if (y < 1900) {
            return null;
        }
        cl.set(y, m - 1, d, 0, 0, 0);
        cl.set(Calendar.MILLISECOND, 0);
        return cl.getTime();
    }

    /**
     * Получение список дней для актульного года.
     *
     * @return Результат.
     */
    public static ArrayList<Integer> GetDaysByActualYear() {
        ArrayList<Integer> result = new ArrayList<>();
        Calendar tempCalendar = Calendar.getInstance();
        int actualYear = calendar.get(Calendar.YEAR) - 1900;
        Date beginDay = new Date(actualYear, 0, 1);
        Date endDay = new Date(actualYear, 11, 31);
        tempCalendar.setTime(beginDay);
        while (tempCalendar.getTime().getTime() <= endDay.getTime()) {
            result.add(IntDateTime(tempCalendar.getTime()));
            tempCalendar.add(Calendar.DATE, 1);
        }
        return result;
    }

    /**
     * Округление продолжительности, до значимой минуты.
     *
     * @param inputDur Продолжительность.
     * @return Результат.
     */
    public static int GetSignificantMinuts(int inputDur) {
        if (inputDur < 30) {
            return 60;
        }
        return ((inputDur + 30) / 60) * 60;
    }
    
     /**
     * Округление продолжительности, до значимой минуты.
     *
     * @param inputDur Продолжительность.
     * @return Результат.
     */
    public static int GetSignificantMinuts(short inputDur) {
        return GetSignificantMinuts(Integer.valueOf(inputDur));
    }
    
}