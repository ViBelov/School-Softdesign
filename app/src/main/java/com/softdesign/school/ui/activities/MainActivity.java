package com.softdesign.school.ui.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.softdesign.school.R;
import com.softdesign.school.ui.fragments.ContactsFragment;
import com.softdesign.school.ui.fragments.ProfileFragment;
import com.softdesign.school.ui.fragments.SettingsFragment;

import com.softdesign.school.ui.fragments.TasksFragment;
import com.softdesign.school.ui.fragments.TeamsFragment;
import com.softdesign.school.utils.Lg;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VISIBLE_KEY = "visible";

    CheckBox mCheckBox;
    EditText mEditText;
    EditText mEditText2;
    Toolbar mToolbar;

    Button mBtnRed;
    Button mBtnBlue;
    Button mBtnGreen;

    private NavigationView mNavigationView;
    private DrawerLayout mNavigationDrawer;

    private Fragment mFragment;
    private FrameLayout mFrameContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Lg.i(this.getLocalClassName(), "-----------------------------");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("School Lesson 1");
        Lg.i(this.getLocalClassName(), "on create");

        mNavigationDrawer = (DrawerLayout) findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView) findViewById(R.id.navigtaion_view);

        setupDrawer();

        //mCheckBox = (CheckBox)findViewById(R.id.checkBox);
        //mCheckBox.setOnClickListener(this);

        //mEditText = (EditText)findViewById(R.id.editText1);
        //mEditText2 = (EditText)findViewById(R.id.editText2);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setupToolbar();

//        mBtnRed = (Button)findViewById(R.id.btn_red);
//        mBtnRed.setOnClickListener(this);
//
//        mBtnBlue = (Button)findViewById(R.id.btn_blue);
//        mBtnBlue.setOnClickListener(this);
//
//        mBtnGreen = (Button)findViewById(R.id.btn_green);
//        mBtnGreen.setOnClickListener(this);


        if(savedInstanceState != null){
         int visibleState = savedInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE;
//            mEditText.setVisibility(visibleState);
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, new ProfileFragment()).commit();
        }
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
            /*Toast.makeText(this, "Click!", Toast.LENGTH_SHORT).show();*/
            mNavigationDrawer.openDrawer(GravityCompat.START);
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
        //outState.putBoolean(VISIBLE_KEY, mEditText2.getVisibility() == View.VISIBLE);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.e(this.getLocalClassName(), "on restore instance state");
        int visibleState = savedInstanceState.getBoolean(VISIBLE_KEY) ? View.VISIBLE : View.INVISIBLE;
        //mEditText2.setVisibility(visibleState);
    }

    int chkbox = R.id.drawer_profile; //переменная в которую помещается id текущего пункта меню
    // обработка переключения пунктов меню
    private void setupDrawer(){
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            //int chkbox = R.id.drawer_profile;
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mNavigationView.getMenu().findItem(chkbox).setChecked(false); //выключение чекбокса текущего пункта меню

                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
                        chkbox=R.id.drawer_profile;
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        chkbox=R.id.drawer_contacts;
                        break;
                    case R.id.drawer_settings:
                        mFragment = new SettingsFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_settings).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        chkbox=R.id.drawer_settings;
                        break;
                    case R.id.drawer_teams:
                        mFragment = new TeamsFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_teams).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        chkbox=R.id.drawer_teams;
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TasksFragment();
                        mNavigationView.getMenu().findItem(R.id.drawer_tasks).setChecked(true);
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        chkbox=R.id.drawer_tasks;
                        break;

                }
                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, mFragment).addToBackStack(null).commit();
                }
                mNavigationDrawer.closeDrawers();
                return false;
            }
        });
    }
    //обработка нажатия кнопки "НАЗАД"
    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
            mNavigationView.getMenu().findItem(chkbox).setChecked(false);
            switch (String.valueOf(getTitle())) {
                case "Профиль":
                    mNavigationView.getMenu().findItem(R.id.drawer_profile).setCheckable(true);
                    mNavigationView.setCheckedItem(R.id.drawer_profile);

                    break;
                case "Контакты":
                    mNavigationView.getMenu().findItem(R.id.drawer_contacts).setCheckable(true);
                    mNavigationView.setCheckedItem(R.id.drawer_contacts);
                    break;
                case "Команды":
                    mNavigationView.getMenu().findItem(R.id.drawer_teams).setCheckable(true);
                    mNavigationView.setCheckedItem(R.id.drawer_teams);
                    break;
                case "Задачи":
                    mNavigationView.getMenu().findItem(R.id.drawer_tasks).setCheckable(true);
                    mNavigationView.setCheckedItem(R.id.drawer_tasks);
                    break;
                case "Настройки":
                    mNavigationView.getMenu().findItem(R.id.drawer_settings).setCheckable(true);
                    mNavigationView.setCheckedItem(R.id.drawer_settings);
                    break;
            }
        } else {
            finish();
            System.exit(0);
            }

        }
    }