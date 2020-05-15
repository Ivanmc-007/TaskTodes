package com.ivan.testTask.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateParser {
    private final static String FORMAT_DATE = "dd.MM.yyyy";
    private final static DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
    static {
        // By default, SimpleDateFormat.setLenient() is set to true,
        // you should always turn it off to make your date validation more strictly.
        dateFormat.setLenient(false);
    }

    public static String getJustDate(Date date) {
        return dateFormat.format(date);
    }
}
