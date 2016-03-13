package com.softdesign.school.ui.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.activeandroid.query.Select;
import com.softdesign.school.R;
import com.softdesign.school.data.storage.model.Team;
import com.softdesign.school.data.storage.model.User;
import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.ui.adapters.ContactAdapter;

import java.util.ArrayList;
import java.util.List;


public class ContactsFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<User>>   {
    //ArrayList<User> mUsers = new ArrayList<User>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mTeam;
    private Spinner mSpinner;
    RecyclerView listContacts;
    View mainView;
    View dialogView;
    View dialogView1;
    List<User> mUsers;
    List<Team> mTeams;


    public ContactsFragment() {
        this.setRetainInstance(true); // непересоздавать фрагмент при повороте экрана
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        loadData();
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


        dialogView = inflater.inflate(R.layout.dialog_add_user,null,false);
        dialogView1 = inflater.inflate(R.layout.dialog_add_team,null,false);

        mFirstName = (EditText) dialogView.findViewById(R.id.first_name_add);
        mLastName = (EditText) dialogView.findViewById(R.id.last_name_add);
        mTeam = (EditText) dialogView1.findViewById(R.id.team_add_name);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getAllNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner = (Spinner) dialogView.findViewById(R.id.team_spinner_add);
        spinner.setAdapter(adapter);


        listContacts = (RecyclerView) mainView.findViewById(R.id.list_view);
        listContacts.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        listContacts.setLayoutManager(mLayoutManager);

        listContacts.setAdapter(mAdapter);

        ((MainActivity) getActivity()).lockAppBar(true);
        return mainView;



    }

    private void saveData(){
        User user = new User(mFirstName.getText().toString(),mLastName.getText().toString(),null);
        user.save();
        mFirstName.getText();

    }

    private void saveData1(){
        Team team = new Team(mTeam.getText().toString());
        team.save();
        mTeam.getText();

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
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Создать команду или пользователя?")
                        .setCancelable(false)
                        .setPositiveButton("Создать пользователя",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                        builder.setTitle("Создать пользователя")
                                                .setCancelable(false)
                                                .setPositiveButton("Готово",
                                                        new DialogInterface.OnClickListener() {
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                saveData();
                                                                getLoaderManager().initLoader(0, null, ContactsFragment.this).forceLoad();
                                                                dialog.cancel();

                                                            }

                                                        })

                                                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        dialog.cancel();
                                                    }
                                                })
                                                .setView(dialogView);
                                        AlertDialog alertDialog = builder.create();
                                        alertDialog.show();

                                    }

                                })

                        .setNegativeButton("Создать команду", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                builder.setTitle("Создать команду")
                                        .setCancelable(false)
                                        .setPositiveButton("Готово",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        //mTeams = getDataListTeams();
                                                        saveData1();
                                                        getLoaderManager().initLoader(0, null, ContactsFragment.this).forceLoad();
                                                        dialog.cancel();

                                                    }

                                                })

                                        .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        })
                                        .setView(dialogView1);
                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });

    }//

    public List<String> getAllNames() {
        List<Team> teams = getDataListTeams();
        List<String> names = new ArrayList<>(teams.size());
        for (Team t : teams) {
            names.add(t.mTeam);
        }
        return names;
    }

    public void loadData() {
        mUsers = getDataListUsers();
        mTeams = getDataListTeams();

    }

    public List<User> getDataListUsers() {
        return new Select()
                .from(User.class)
                .execute();
    }

    public List<Team> getDataListTeams() {
        return new Select()
                .from(Team.class)
                .execute();
    }

    @Override
    public Loader<List<User>> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<List<User>>(getContext()) {
            @Override
            public List<User> loadInBackground() {
            return getDataListUsers();
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<List<User>> loader, List<User> data) {
        mAdapter = new ContactAdapter(data);
        listContacts.setAdapter(mAdapter);
    }

    @Override
    public void onLoaderReset(Loader<List<User>> loader) {

    }
}

