package com.myst3ry.catchmovie;

import android.os.Build;

import java.util.Locale;

public final class DeviceConfigurationHelper {

    private static final String DEVICE_INFO_FORMAT = "%s %s (%s)";
    private static final String VERSION_INFO_FORMAT = "%s (%d)";

    public static String getDeviceInfo() {
        return String.format(DEVICE_INFO_FORMAT, Build.MANUFACTURER, Build.MODEL, Build.DEVICE);
    }

    public static String getBuildInfo() {
        return Build.ID;
    }

    public static String getVersionInfo() {
        return String.format(Locale.getDefault(), VERSION_INFO_FORMAT, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
    }

    public static String getAppVersionInfo() {
        return BuildConfig.VERSION_NAME;
    }

    private DeviceConfigurationHelper() {
    }
}
