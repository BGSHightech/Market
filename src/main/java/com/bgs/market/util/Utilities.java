package com.bgs.market.util;

import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Utilities {

    public static final String FORMAT_DATE_DDMMYYYY = "dd/MM/yyyy";
    public static final String FORMAT_DATE_DDMMYYYYHHMMSS = "dd/MM/yyyy HH:mm:ss";

    /**
     * Get message i18n with Local.Default
     * @param messageSource represents messageSource
     * @param message represents message
     * @return messageSource
     */
    public static String getMessage(MessageSource messageSource, String message){
        return messageSource.getMessage(message, null, Locale.getDefault());
    }

    /**
     * Get message i18n with Local.Default and params
     * @param messageSource represents messageSource
     * @param param represents param
     * @param message represents message
     * @return messageSource
     */
    public static String getMessage(MessageSource messageSource, Object[] param, String message){
        return messageSource.getMessage(message, param, Locale.getDefault());
    }

    /**
     * Get date with format and convert to String value
     * @param date represents date
     * @param format represents format
     * @return String value
     */
    public static String dateToString(Date date, String format) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * Get date with format and convert to Date value
     * @param date represents date
     * @param format represents format
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
