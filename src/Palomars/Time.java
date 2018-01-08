/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Palomars;

import java.sql.Timestamp;
import java.util.*;
import static utils.TimeHelper.NormalDateTime;

/**
 * Класс для работы с объектами времени в Паломарсе.
 *
 * @author deema
 */
public class Time {

    /**
     * Конструктор.
     */
    public Time() {
    }

    /**
     * Приведение нормального времени, ко времение паломарс. Длительности от
     * 5000 до 29000.
     *
     * @param date Нормальное время.
     * @return Результат.
     */
    public static int ToPalomarsTime(Date date) {
        Calendar stepTime = Calendar.getInstance();
        stepTime.set(0, 0, 1, 5, 0, 0);
        stepTime.set(Calendar.MILLISECOND, 0);
        int path = date.getTime() < stepTime.getTimeInMillis() ? 240000 : 0;
        int hours = date.getHours() * 10000;
        int minutes = date.getMinutes() * 100;
        int seconds = date.getSeconds();
        int total = path + hours + minutes + seconds;
        if (total == 0) {
            total = 240000;
        }
        return total;
    }

    /**
     * Преобразование времени паломарс, к нормальному времени.
     *
     * @param number Время паломарс.
     * @return Результат.
     */
    public static Date NormalTime(int number) {
        int hours = (number / 10000);
        if(hours > 24){
            hours -= 24;
        }
        int minutes = ((number % 10000) / 100);
        int seconds = (number % 100);
        Calendar calendar = Calendar.getInstance();
        calendar.set(0, 0, 1, hours, minutes, seconds);
        calendar.set(Calendar.MILLISECOND, 0);
        Date result = calendar.getTime();
        return result;
    }

    /**
     * Возвращение времени без секунд.
     *
     * @param time Время паломарс.
     * @return Результат.
     */
    public static Date WithoutSeconds(int time) {
        Date normalTime = NormalTime(time);
        Calendar stepTime = Calendar.getInstance();
        stepTime.set(0, 0, 1, normalTime.getHours(), normalTime.getMinutes(), 0);
        stepTime.set(Calendar.MILLISECOND, 0);
        return stepTime.getTime();
    }
}
