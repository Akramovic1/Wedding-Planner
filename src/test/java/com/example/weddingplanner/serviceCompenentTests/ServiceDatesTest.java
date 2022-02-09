package com.example.weddingplanner.serviceCompenentTests;

import com.example.weddingplanner.model.serviceComponent.serviceAppendices.ServiceDate;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceDatesTest {
    /*
    test the function comingFreeNDays
     */
    @Test
    void comingFreeNDaysPositiveN() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = formatter.parse("2019-04-1");
            a.add(date);
            date = formatter.parse("2021-04-3");
            a.add(date);
            date = formatter.parse("2021-04-4");
            a.add(date);
            date = formatter.parse("2021-04-6");
            a.add(date);
            date = formatter.parse("2021-04-9");
            a.add(date);
            date = formatter.parse("2021-04-12");
            a.add(date);
            date = formatter.parse("2022-01-14");
            a.add(date);
            date = formatter.parse("2022-01-15");
            a.add(date);
            date = formatter.parse("2022-01-17");
            a.add(date);
            date = formatter.parse("2022-01-18");
            a.add(date);
            date = formatter.parse("2022-01-21");
            a.add(date);
            List<Date> coming=s.comingFreeNDays(a,30);
            date=new Date();
            int starting = s.binarySearch(a,0,a.size()-1,date);
            int busyLength=a.size()-starting;
            assertEquals(30-busyLength,coming.size());
        }
        catch (ParseException e) {
            //e.printStackTrace();
            fail("Error in formatting current date");
        }
    }
    @Test
    void comingFreeNDaysNegativeN() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = sdformat.parse("2019-04-1");
            a.add(date);
            date = sdformat.parse("2021-04-3");
            a.add(date);
            date = sdformat.parse("2021-04-4");
            a.add(date);
            date = sdformat.parse("2021-04-6");
            a.add(date);
            date = sdformat.parse("2021-04-9");
            a.add(date);
            date = sdformat.parse("2021-04-12");
            a.add(date);
            date = sdformat.parse("2022-01-14");
            a.add(date);
            date = sdformat.parse("2022-01-15");
            a.add(date);
            date = sdformat.parse("2022-01-17");
            a.add(date);
            date = sdformat.parse("2022-01-18");
            a.add(date);
            date = sdformat.parse("2022-01-21");
            a.add(date);
            List<Date> coming=s.comingFreeNDays(a,-10);
            assertEquals(0,coming.size());
        }
        catch (ParseException e) {
            //e.printStackTrace();
            fail("Error in formatting current date");
        }
    }
    @Test
    void comingFreeNDaysZeroN() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = sdformat.parse("2019-04-1");
            a.add(date);
            date = sdformat.parse("2021-04-3");
            a.add(date);
            date = sdformat.parse("2021-04-4");
            a.add(date);
            date = sdformat.parse("2021-04-6");
            a.add(date);
            date = sdformat.parse("2021-04-9");
            a.add(date);
            date = sdformat.parse("2021-04-12");
            a.add(date);
            date = sdformat.parse("2022-01-14");
            a.add(date);
            date = sdformat.parse("2022-01-15");
            a.add(date);
            date = sdformat.parse("2022-01-17");
            a.add(date);
            date = sdformat.parse("2022-01-18");
            a.add(date);
            date = sdformat.parse("2022-01-21");
            a.add(date);
            List<Date> coming=s.comingFreeNDays(a,0);
            assertEquals(0,coming.size());
        }
        catch (ParseException e) {
            //e.printStackTrace();
            fail("Error in formatting current date");
        }
    }
    @Test
    void comingFreeNDaysLastBusyDay() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse("2019-04-1");
            a.add(date);
            date = formatter.parse("2021-04-3");
            a.add(date);
            date = formatter.parse("2021-04-4");
            a.add(date);
            date = formatter.parse("2021-04-6");
            a.add(date);
            date = formatter.parse("2021-04-9");
            a.add(date);
            date = formatter.parse("2021-04-12");
            a.add(date);
            date = formatter.parse("2021-05-14");
            a.add(date);
            date = formatter.parse("2021-06-15");
            a.add(date);
            date = formatter.parse("2021-07-17");
            a.add(date);
            date = formatter.parse("2021-08-18");
            a.add(date);
            date = formatter.parse("2021-09-21");
            a.add(date);
            List<Date> coming=s.comingFreeNDays(a,30);
            assertEquals(30,coming.size());
        }
        catch (ParseException e) {
            //e.printStackTrace();
            fail("Error in formatting current date");
        }
    }
    @Test
    void comingFreeNDaysNotBusyBeforeToday() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        List<Date> coming=s.comingFreeNDays(a,30);
        date=new Date();
        int starting = s.binarySearch(a,0,a.size()-1,date);
        assertEquals(0,starting);
        int busyLength=a.size()-starting;
        assertEquals(30-busyLength,coming.size());
    }
    @Test
    void comingFreeNDaysNullBusyList() {
        ServiceDate s=new ServiceDate();
        List<Date> coming=s.comingFreeNDays(null,30);
        assertEquals(30,coming.size());
    }
    /*
    test the function freeComingThirtyDays
     */
    @Test
    void freeComingThirtyDaysRight() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = formatter.parse("2019-04-1");
            a.add(date);
            date = formatter.parse("2021-04-3");
            a.add(date);
            date = formatter.parse("2021-04-4");
            a.add(date);
            date = formatter.parse("2021-04-6");
            a.add(date);
            date = formatter.parse("2021-04-9");
            a.add(date);
            date = formatter.parse("2021-04-12");
            a.add(date);
            date = formatter.parse("2022-01-14");
            a.add(date);
            date = formatter.parse("2022-01-15");
            a.add(date);
            date = formatter.parse("2022-01-17");
            a.add(date);
            date = formatter.parse("2022-01-18");
            a.add(date);
            date = formatter.parse("2022-01-21");
            a.add(date);
            List<Date> coming=s.freeComingThirtyDays(a);
            date=new Date();
            int starting = s.binarySearch(a,0,a.size()-1,date);
            int busyLength=a.size()-starting;
            assertEquals(30-busyLength,coming.size());
        }
        catch (ParseException e) {
            //e.printStackTrace();
            fail("Error in formatting current date");
        }
    }
    @Test
    void freeComingThirtyDaysLastBusyDay() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse("2019-04-1");
            a.add(date);
            date = formatter.parse("2021-04-3");
            a.add(date);
            date = formatter.parse("2021-04-4");
            a.add(date);
            date = formatter.parse("2021-04-6");
            a.add(date);
            date = formatter.parse("2021-04-9");
            a.add(date);
            date = formatter.parse("2021-04-12");
            a.add(date);
            date = formatter.parse("2021-05-14");
            a.add(date);
            date = formatter.parse("2021-06-15");
            a.add(date);
            date = formatter.parse("2021-07-17");
            a.add(date);
            date = formatter.parse("2021-08-18");
            a.add(date);
            date = formatter.parse("2021-09-21");
            a.add(date);
            List<Date> coming=s.freeComingThirtyDays(a);
            assertEquals(30,coming.size());
        }
        catch (ParseException e) {
            //e.printStackTrace();
            fail("Error in formatting current date");
        }
    }
    @Test
    void freeComingThirtyDaysNotBusyBeforeToday() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        List<Date> coming=s.freeComingThirtyDays(a);
        date=new Date();
        int starting = s.binarySearch(a,0,a.size()-1,date);
        assertEquals(0,starting);
        int busyLength=a.size()-starting;
        assertEquals(30-busyLength,coming.size());
    }
    @Test
    void freeComingThirtyDaysNullBusyList() {
        ServiceDate s=new ServiceDate();
        List<Date> coming=s.freeComingThirtyDays(null);
        assertEquals(30,coming.size());
    }
    /*
    test the function freeWithInThatMouth
     */
    @Test
    void freeWithInThatMouthRight() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = formatter.parse("2019-04-1");
            a.add(date);
            date = formatter.parse("2021-04-3");
            a.add(date);
            date = formatter.parse("2021-04-4");
            a.add(date);
            date = formatter.parse("2021-04-6");
            a.add(date);
            date = formatter.parse("2021-04-9");
            a.add(date);
            date = formatter.parse("2021-04-12");
            a.add(date);
            date = formatter.parse("2022-01-14");
            a.add(date);
            date = formatter.parse("2022-01-15");
            a.add(date);
            date = formatter.parse("2022-01-17");
            a.add(date);
            date = formatter.parse("2022-01-18");
            a.add(date);
            date = formatter.parse("2022-01-21");
            a.add(date);
            List<Date> coming=s.freeWithInThatMouth(a);
            date=new Date();
            int starting = s.binarySearch(a,0,a.size()-1,date);
            int busyLength=a.size()-starting;
            YearMonth yearMonthObject = YearMonth.of(date.getYear()+1900, date.getMonth()+1);
            int daysInMonth = yearMonthObject.lengthOfMonth();
            SimpleDateFormat dayFormatter = new SimpleDateFormat("dd");
            String day=dayFormatter.format(date);
            assertEquals(daysInMonth-Integer.parseInt(day)+1-busyLength,coming.size());
        }
        catch (ParseException e) {
            //e.printStackTrace();
            fail("Error in formatting current date");
        }
    }
    @Test
    void freeWithInThatMouthLastBusyDay() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse("2019-04-1");
            a.add(date);
            date = formatter.parse("2021-04-3");
            a.add(date);
            date = formatter.parse("2021-04-4");
            a.add(date);
            date = formatter.parse("2021-04-6");
            a.add(date);
            date = formatter.parse("2021-04-9");
            a.add(date);
            date = formatter.parse("2021-04-12");
            a.add(date);
            date = formatter.parse("2021-05-14");
            a.add(date);
            date = formatter.parse("2021-06-15");
            a.add(date);
            date = formatter.parse("2021-07-17");
            a.add(date);
            date = formatter.parse("2021-08-18");
            a.add(date);
            date = formatter.parse("2021-09-21");
            a.add(date);
            List<Date> coming=s.freeWithInThatMouth(a);
            date=new Date();
            int busyLength=0;
            YearMonth yearMonthObject = YearMonth.of(date.getYear()+1900, date.getMonth()+1);
            int daysInMonth = yearMonthObject.lengthOfMonth();
            SimpleDateFormat dayFormatter = new SimpleDateFormat("dd");
            String day=dayFormatter.format(date);
            assertEquals(daysInMonth-Integer.parseInt(day)+1-busyLength,coming.size());
        }
        catch (ParseException e) {
            //e.printStackTrace();
            fail("Error in formatting current date");
        }
    }
    @Test
    void freeWithInThatMouthNotBusyBeforeToday() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        a.add(date);
        List<Date> coming=s.freeWithInThatMouth(a);
        date=new Date();
        int starting = s.binarySearch(a,0,a.size()-1,date);
        int busyLength=a.size()-starting;
        YearMonth yearMonthObject = YearMonth.of(date.getYear()+1900, date.getMonth()+1);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        SimpleDateFormat dayFormatter = new SimpleDateFormat("dd");
        String day=dayFormatter.format(date);
        assertEquals(daysInMonth-Integer.parseInt(day)+1-busyLength,coming.size());
    }
    @Test
    void freeWithInThatMouthNullBusyList() {
        ServiceDate s=new ServiceDate();
        List<Date> coming=s.freeWithInThatMouth(null);
        Date date=new Date();
        YearMonth yearMonthObject = YearMonth.of(date.getYear()+1900, date.getMonth()+1);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        SimpleDateFormat dayFormatter = new SimpleDateFormat("dd");
        String day=dayFormatter.format(date);
        assertEquals(daysInMonth-Integer.parseInt(day)+1,coming.size());
    }
    /*
    test the function isTodayFree
     */
    @Test
    void isTodayFreeTodayBusy() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        a.add(new Date());
        assertFalse(s.isTodayFree(a));
    }
    @Test
    void isTodayFreeTodayFree() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = formatter.parse("2019-04-1");
            a.add(date);
            date = formatter.parse("2021-04-3");
            a.add(date);
            date = formatter.parse("2021-04-4");
            a.add(date);
            date = formatter.parse("2021-04-6");
            a.add(date);
            date = formatter.parse("2021-04-9");
            a.add(date);
            date = formatter.parse("2021-04-12");
            a.add(date);
            assertTrue(s.isTodayFree(a));
        } catch (ParseException e) {
            //e.printStackTrace();
            fail("Error in formatting current date");
        }

    }
    @Test
    void isTodayFreeNullBusy() {
        ServiceDate s=new ServiceDate();
        assertFalse(s.isTodayFree(null));
    }
    /*
    test the function isDateFree
     */
    @Test
    void isDateFreeTodayBusy() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        a.add(new Date());
        assertFalse(s.isDateFree(a,new Date()));
    }
    @Test
    void isDateFreeTodayFree() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = formatter.parse("2019-04-1");
            a.add(date);
            date = formatter.parse("2021-04-3");
            a.add(date);
            date = formatter.parse("2021-04-4");
            a.add(date);
            date = formatter.parse("2021-04-6");
            a.add(date);
            date = formatter.parse("2021-04-9");
            a.add(date);
            date = formatter.parse("2021-04-12");
            a.add(date);
            assertTrue(s.isDateFree(a,new Date()));
        } catch (ParseException e) {
            //e.printStackTrace();
            fail("Error in formatting current date");
        }

    }
    @Test
    void isDateFreeNullBusy() {
        ServiceDate s=new ServiceDate();
        assertFalse(s.isDateFree(null,new Date()));
    }
    @Test
    void isDateFreeNullDate() {
        ServiceDate s=new ServiceDate();
        List<Date> a=new ArrayList<>();
        a.add(new Date());
        assertFalse(s.isDateFree(a,null));
    }
}