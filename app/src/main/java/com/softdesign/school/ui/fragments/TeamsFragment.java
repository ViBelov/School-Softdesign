package com.softdesign.school.ui.fragments;

/**
 * Created by Admin on 05.02.2016.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.R;

public class TeamsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View convertView = inflater.inflate(R.layout.fragment_teams,null,false);
        getActivity().setTitle(getResources().getString(R.string.drawer_teams));
        return convertView;
    }
}
