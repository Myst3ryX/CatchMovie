package com.myst3ry.data.local.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public final class DateConverter {

    @TypeConverter
    public static Date toDate(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long fromDate(Date date) {
        return date == null ? null : date.getTime();
    }
}
