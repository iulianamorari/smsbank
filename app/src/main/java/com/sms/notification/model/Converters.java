package com.sms.notification.model;

import android.arch.persistence.room.TypeConverter;

import java.util.Currency;
import java.util.Date;

/**
 * Created by ruslan on 11/7/17.
 */

public class Converters {
    @TypeConverter
    public static Date dateFromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

    @TypeConverter
    public static Op opFromInteger(Integer value) {
        if (value == null) return Op.UNDEF;
        switch (value) {
            case 1:     return Op.RETRAGERE;
            case 2:     return Op.ALIMENTARE;
            case 3:     return Op.SOLD;
            case 4:     return Op.ACHITARE;
            case 5:     return Op.PLATA;
            default:    return Op.UNDEF;
        }
    }

    @TypeConverter
    public static Integer opToInteger(Op op) {
        switch (op) {
            case UNDEF:         return 0;
            case RETRAGERE:     return 1;
            case ALIMENTARE:    return 2;
            case SOLD:          return 3;
            case ACHITARE:      return 4;
            case PLATA:         return 5;
        }
        return 0;
    }

    @TypeConverter
    public static Status statusFromInteger(Integer value) {
        if (value == null) return Status.UNDEF;
        switch (value) {
            case 1:     return Status.RESPINS;
            case 2:     return Status.REUSIT;
            default:    return Status.UNDEF;
        }
    }

    @TypeConverter
    public static Integer statusToInteger(Status status) {
        switch (status) {
            case UNDEF:     return 0;
            case RESPINS:   return 1;
            case REUSIT:    return 2;
        }
        return 0;
    }

    @TypeConverter
    public static Currency currencyFromString(String value) {
        return value == null ? null : Currency.getInstance(value);
    }

    @TypeConverter
    public static String currencyToString(Currency currency) {
        return currency == null ? null : currency.getCurrencyCode();
    }

}
