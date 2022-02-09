package com.example.weddingplanner.model.serviceComponent.serviceAppendices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ServiceDate implements IServiceDate {
    /*
    list free days in the coming n days
     */
    @Override
    public List<Date> comingFreeNDays(List<Date> busy,int n){
        List<Date> free=new ArrayList<Date>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        String tempFormat=formatter.format(date);
        try {
            date=formatter.parse(tempFormat);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.println("Error in formatting current date");
        }
        if (busy==null){
            for (int i = 0; i < n; i++) {
                free.add(date);
                //increase the day
                c.setTime(date);
                c.add(Calendar.DATE, 1);
                date = c.getTime();
            }
            return free;
        }
        else {
            List<Date> busyCopy = new ArrayList<Date>();
            for (int i = 0; i < busy.size(); i++) {
                Date temp = busy.get(i);
                tempFormat = formatter.format(temp);
                try {
                    temp = formatter.parse(tempFormat);
                    busyCopy.add(i, temp);
                } catch (ParseException e) {
                    //e.printStackTrace();
                    System.out.println("Error in formatting busy date");
                }
            }
            List<Date> comingBusy;
            int starting = binarySearch(busyCopy, 0, busyCopy.size() - 1, date);
            if (starting >= 0) {
                comingBusy = busyCopy.subList(starting, busyCopy.size());
            } else {
                comingBusy = new ArrayList<Date>();
            }
            for (int i = 0; i < n; i++) {
                if (!comingBusy.contains(date)) {
                    free.add(date);
                }
                //increase the day
                c.setTime(date);
                c.add(Calendar.DATE, 1);
                date = c.getTime();
            }
            return free;
        }
    }

    @Override
    public int binarySearch(List<Date> arr, int l, int r, Date x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle
            // itself
            if (arr.get(mid).compareTo(x) == 0) {
                return mid;
            }

            // If element is smaller than mid, then
            // it can only be present in left subarray
            else if (arr.get(mid).compareTo(x) > 0) {
                if (mid==l){
                    return mid;
                }
                else if (arr.get(mid-1).compareTo(x)>0) {
                    return binarySearch(arr, l, mid - 1, x);
                }
                else {
                    return mid;
                }
            }

            // Else the element can only be present
            // in right subarray
            else {
                if (mid==r){
                    return -1;
                }
                if (arr.get(mid+1).compareTo(x)<0) {
                    return binarySearch(arr, mid + 1, r, x);
                }
                else {
                    return mid+1;
                }

            }
        }

        // We reach here when element is not
        // present in array
        return -1;
    }

    /*
    list free days in the coming 30 days
     */
    @Override
    public List<Date> freeComingThirtyDays(List<Date> busy){
        return comingFreeNDays(busy,30);
    }

    /*
    list free days in the coming days with in current month
     */
    @Override
    public List<Date> freeWithInThatMouth(List<Date> busy){
        Date date=new Date();
        YearMonth yearMonthObject = YearMonth.of(date.getYear()+1900, date.getMonth()+1);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        SimpleDateFormat dayFormatter = new SimpleDateFormat("dd");
        String day=dayFormatter.format(date);
        return comingFreeNDays(busy,daysInMonth-Integer.parseInt(day)+1);
    }

    /*
    check if today is free
     */
    @Override
    public boolean isTodayFree(List<Date> busy){
        if (busy==null){
            return false;
        }
        else {
            List<Date> busyCopy = new ArrayList<Date>();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 0; i < busy.size(); i++) {
                Date temp = busy.get(i);
                String tempFormat = formatter.format(temp);
                try {
                    temp = formatter.parse(tempFormat);
                    busyCopy.add(i, temp);
                } catch (ParseException e) {
                    //e.printStackTrace();
                    System.out.println("Error in formatting busy date");
                }
            }
            Date date = new Date();
            String tempFormat = formatter.format(date);
            try {
                date = formatter.parse(tempFormat);
            } catch (ParseException e) {
                //e.printStackTrace();
                System.out.println("Error in formatting current date");
            }
            return !busyCopy.contains(date);
        }
    }

    /*
    check if today is free
     */
    @Override
    public boolean isDateFree(List<Date> busy,Date date){
        if (busy==null||date==null){
            return false;
        }
        else {
            List<Date> busyCopy = new ArrayList<Date>();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 0; i < busy.size(); i++) {
                Date temp = busy.get(i);
                String tempFormat = formatter.format(temp);
                try {
                    temp = formatter.parse(tempFormat);
                    busyCopy.add(i, temp);
                } catch (ParseException e) {
                    //e.printStackTrace();
                    System.out.println("Error in formatting busy date");
                }
            }
            String tempFormat = formatter.format(date);
            try {
                date = formatter.parse(tempFormat);
            } catch (ParseException e) {
                //e.printStackTrace();
                System.out.println("Error in formatting current date");
            }
            return !busyCopy.contains(date);
        }
    }

    public static void main(String[] args) throws ParseException {
        List<Date> a=new ArrayList<Date>();
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
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
        date=new Date();
        ServiceDate s=new ServiceDate();
        System.out.println(s.binarySearch(a,0,a.size()-1,date));
        System.out.println(s.comingFreeNDays(a,60));
    }
}
/*public static int getPredecessor(List<Integer> inpArr, int key) {
        int minDiff = Math.abs(key);
        int pred = key;
        if(inpArr.get(0) < key) {
            minDiff = key - inpArr.get(0);
            pred = inpArr.get(0);
        }
        for(int i=0;i<inpArr.size();i++) {
            if(inpArr.get(i) < key && (key - inpArr.get(i))<=minDiff)
            {
                minDiff = key - inpArr.get(i);
                pred = inpArr.get(i);
            }
        }
        return pred;
    }*/