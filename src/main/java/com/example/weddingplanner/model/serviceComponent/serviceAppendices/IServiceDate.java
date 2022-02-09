package com.example.weddingplanner.model.serviceComponent.serviceAppendices;

import java.util.Date;
import java.util.List;

public interface IServiceDate {
    /*
    list free days in the coming n days
     */
    List<Date> comingFreeNDays(List<Date> busy, int n);
    /*
    return the first index of the Date that equals to x or coming directly after if
     */
    int binarySearch(List<Date> arr, int l, int r, Date x);
    /*
    list free days in the coming 30 days
     */
    List<Date> freeComingThirtyDays(List<Date> busy);
    /*
    list free days in the coming days with in current month
     */
    List<Date> freeWithInThatMouth(List<Date> busy);
    /*
    check if today is free
     */
    boolean isTodayFree(List<Date> busy);
    /*
    check if today is free
     */
    boolean isDateFree(List<Date> busy,Date date);
}
