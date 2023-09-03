package com.bgs.market.util;

import org.springframework.context.MessageSource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utilities {

    public static final String FORMAT_DATE_DDMMYYYY = "dd/MM/yyyy";
    public static final String FORMAT_DATE_DDMMYYYYHHMMSS = "dd/MM/yyyy HH:mm:ss";

    /**
     * Get message i18n with Local.Default
     * @param messageSource
     * @param message
     * @return
     */
    public static String getMessage(MessageSource messageSource, String message){
        return messageSource.getMessage(message, null, Locale.getDefault());
    }

    /**
     * Get message i18n with Local.Default and params
     * @param messageSource
     * @param param
     * @param message
     * @return
     */
    public static String getMessage(MessageSource messageSource, Object[] param, String message){
        return messageSource.getMessage(message, param, Locale.getDefault());
    }

    /**
     * Get date with format and convert to String value
     * @param date
     * @param format
     * @return String value
     * @throws Exception
     */
    public static String dateToString(Date date, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * Get date with format and convert to Date value
     * @param date
     * @param format
     * @return Date value
     */
    public static Date stringToDate(String date, String format){
        if (date == null){
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date parsedDate = null;
        try{
            parsedDate = dateFormat.parse(date);
        }
        catch (ParseException e){
            //
        }
        return parsedDate;
    }
}
