package com.georgiy.denga;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateConverter {

    public DateConverter() {
    }

    public static String toString(Date date) {
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        return ft.format(date);
    }

    public static java.util.Date toUtilDate(String dateStr) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat("ddMMyyyy");
        java.util.Date date = ft.parse(dateStr);
        return date;
    }

//    public static java.sql.Date toSqlDate(java.util.Date date) {
//        return new java.sql.Date(date.getTime());
//    }
//
//    public static java.sql.Date toSqlDate(String dateStr) {
//        try {
//            java.sql.Date date = toSqlDate(toDateTime(dateStr));
//            return date;
//        } catch (ParseException var2) {
//            throw new IllegalStateException("Couldn't parse Date");
//        }
//    }
}
