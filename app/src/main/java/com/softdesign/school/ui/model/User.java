package com.softdesign.school.ui.model;

import android.graphics.drawable.Drawable;


public class User {

    private String mFirstName;
    private String mLastName;
    private int mRait;
    private Drawable mImage;
    private String mVkLink;
    private String mGitLink;
    private int mHomeTask;

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