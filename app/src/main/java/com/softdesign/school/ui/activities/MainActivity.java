package com.softdesign.school.ui.activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.softdesign.school.R;
import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VISIBLE_KEY = "visible";

    CheckBox mCheckBox;
    EditText mEditText;
    EditText mEditText2;
    Toolbar mToolbar;

    Button mBtnRed;
    Button mBtnBlue;
    Button mBtnGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Lg.i(this.getLocalClassName(), "-----------------------------");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("School Lesson 1");
        Lg.i(this.getLocalClassName(), "on create");



        mCheckBox = (CheckBox)findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);

        mEditText = (EditText)findViewById(R.id.editText1);
        mEditText2 = (EditText)findViewById(R.id.editText2);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setupToolbar();

        mBtnRed = (Button)findViewById(R.id.btn_red);
        mBtnRed.setOnClickListener(this);

        mBtnBlue = (Button)findViewById(R.id.btn_blue);
        mBtnBlue.setOnClickListener(this);

        mBtnGreen = (Button)findViewById(R.id.btn_green);
        mBtnGreen.setOnClickListener(this);
    }

    private void  setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.checkBox:
                Toast.makeText(this, "Click CheckBox", Toast.LENGTH_SHORT).show();
                if (mCheckBox.isChecked()) {
                    mEditText2.setVisibility(View.INVISIBLE);
                } else {
                  mEditText2.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.btn_red:

                mToolbar.setBackgroundColor(getResources().getColor(R.color.color_red));
                break;
            case R.id.btn_blue:

                mToolbar.setBackgroundColor(getResources().getColor(R.color.color_blue));
                break;
            case R.id.btn_green:

                mToolbar.setBackgroundColor(getResources().getColor(R.color.color_green));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Lg.e(this.getLocalClassName(), "on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Lg.e(this.getLocalClassName(), "on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lg.e(this.getLocalClassName(), "on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Lg.e(this.getLocalClassName(), "on stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.e(this.getLocalClassName(), "on restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.e(this.getLocalClassName(), "on destroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.e(this.getLocalClassName(), "on save instance state");
        outState.putBoolean(VISIBLE_KEY, mEditText2.getVisibility() == View.VISIBLE);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "on restore instance state");
        int visibleState = savedInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE;
        mEditText2.setVisibility(visibleState);
    }
}