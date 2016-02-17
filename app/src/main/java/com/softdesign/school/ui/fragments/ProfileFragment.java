package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;

import java.util.zip.Inflater;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.navigation_view);
        //чек в меню
        navigationView.getMenu().findItem(R.id.drawer_profile).setChecked(true);
        //инфлейтер фрагмента
        View convertView = inflater.inflate(R.layout.fragment_profile,null,false);
        //getActivity().setTitle(getResources().getString(R.string.fragment_profile_title));
        ((MainActivity) getActivity()).lockAppBar(false);
        return convertView;
    }

    //обработчик кнопки (смена иконки и перемещение)
    @Override
        public void onActivityCreated(Bundle savedInstanceState) {
                super.onActivityCreated(savedInstanceState);
                FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
                CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
                params.setAnchorId(R.id.appbar_layout);
                params.anchorGravity = Gravity.BOTTOM | Gravity.RIGHT;
                fab.setLayoutParams(params);
                fab.setImageResource(R.drawable.ic_edit_24dp);
                }

}

