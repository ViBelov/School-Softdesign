/* логи */

package com.softdesign.school.utils;

import android.util.Log;

public class Lg {

    //префикс, для указания в начале сообщения
    private static final String PREFIX = "SCHOOL ";

    //max длинна, при преышении - перенос
    public static final int LOGCAT_BUFFER_SIZE = 3000;

    private Lg() {
    }

    private static boolean shouldLog() {
        // return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
        return true;
    }

    //Log.VERBOSE, тэг, сообщение
    public static void v(String tag, String msg) {
        helper(Log.VERBOSE, tag, msg);
    }

    //Log.DEBUG, тэг, сообщение
    public static void d(String tag, String msg) {
        helper(Log.DEBUG, tag, msg);
    }

    //Log.INFO, тэг, сообщение
    public static void i(String tag, String msg) {
        helper(Log.INFO, tag, msg);
    }


     //Log.WARN, тэг, сообщение
    public static void w(String tag, String msg) {
        helper(Log.WARN, tag, msg);
    }

    //Log.ERROR, тэг, сообщение
    public static void e(String tag, String msg) {
        helper(Log.ERROR, tag, msg);
    }

    //Log.ASSERT, тэг, сообщение
    public static void aa(String tag, String msg) {
        helper(Log.ASSERT, tag, msg);
    }


     // Хэлепер
     //Учитывает буфер, перенос строки
     //принимает приоритет, тэг, сообщение

    private static void helper(Integer level, String tag, String msg) {
        if (shouldLog()) {
            String str = msg;

            while (str.length() > LOGCAT_BUFFER_SIZE) {
                String substr = str.substring(0, LOGCAT_BUFFER_SIZE);
                str = substr.substring(LOGCAT_BUFFER_SIZE);
                log(level, PREFIX + tag, substr);
            }

            log(level, PREFIX + tag, str);
        }
    }

    //метод android.util.Log
    //принимает уровень приритета, тэг, сообщение
    private static void log(Integer level, String tag, String msg) {
        switch (level) {
            case Log.VERBOSE:
                Log.v(tag, msg);
                break;
            case Log.DEBUG:
                Log.d(tag, msg);
                break;
            case Log.INFO:
                Log.i(tag, msg);
                break;
            case Log.WARN:
                Log.w(tag, msg);
                break;
            case Log.ERROR:
                Log.e(tag, msg);
                break;
        }
    }
}