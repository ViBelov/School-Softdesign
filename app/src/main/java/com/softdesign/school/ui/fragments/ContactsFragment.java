package com.softdesign.school.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.design.widget.NavigationView;

import com.softdesign.school.R;
import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.ui.adapters.ContactAdapter;

import java.util.ArrayList;


public class ContactsFragment extends Fragment {
    ArrayList<User> mUsers = new ArrayList<User>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView listContacts;
    View mainView;
    public ContactsFragment() {
        this.setRetainInstance(true); // непересоздавать фрагмент при повороте экрана
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        generateData();
        mAdapter = new ContactAdapter(mUsers);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mainView == null) {
         mainView = inflater.inflate(R.layout.fragment_contacts, container, false);
        }

        NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.navigation_view);
        //чек в меню
        navigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
        getActivity().setTitle(getResources().getString(R.string.fragment_contacts_title));

        generateData();
        //добавление контактов
        listContacts = (RecyclerView) mainView.findViewById(R.id.list_view);
        listContacts.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        listContacts.setLayoutManager(mLayoutManager);

        listContacts.setAdapter(mAdapter);

        ((MainActivity) getActivity()).lockAppBar(true);
        return mainView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        params.setAnchorId(R.id.coordinator_container);
        params.anchorGravity = Gravity.BOTTOM | Gravity.RIGHT;
        fab.setLayoutParams(params);
        fab.setImageResource(R.drawable.ic_add_24dp);
        fab.show();
    }
    //генерируем контакты
    private void generateData() {
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_box_24dp), "Иванов", "Иван"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_box_24dp), "Петров", "Петр"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_box_24dp), "Николаев", "Николай"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.ic_account_box_24dp), "Стас", "Михайлов"));
            }
}

