package com.softdesign.school.ui.fragments;

import android.graphics.drawable.Drawable;


public class User {

    private String mFirstName;
    private String mLastName;
    private Drawable mImage;

    public User(Drawable mImage, String mFirstName, String mLastName) {
        this.mImage = mImage;
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }
    public Drawable getmImage() {
                return mImage;
    }
}