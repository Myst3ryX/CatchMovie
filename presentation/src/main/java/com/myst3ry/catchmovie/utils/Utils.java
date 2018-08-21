package com.myst3ry.catchmovie.utils;

import android.os.Build;

import com.myst3ry.catchmovie.BuildConfig;

import java.util.Locale;

public final class Utils {

    public static String getDeviceInfo() {
        return String.format("%s %s (%s)", Build.MANUFACTURER, Build.MODEL, Build.DEVICE);
    }

    public static String getBuildInfo() {
        return Build.ID;
    }

    public static String getVersionInfo() {
        return String.format(Locale.getDefault(), "%s (%d)", Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
    }

    public static String getAppVersionInfo() {
        return BuildConfig.VERSION_NAME;
    }

    private Utils() {
    }
}
