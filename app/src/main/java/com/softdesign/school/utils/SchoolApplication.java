package com.softdesign.school.utils;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.activeandroid.ActiveAndroid;

public class SchoolApplication extends Application {

    public static SharedPreferences sPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        sPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        ActiveAndroid.initialize(this);
    }

    public static SharedPreferences getPreferences() {
        return sPreferences;
    }


}