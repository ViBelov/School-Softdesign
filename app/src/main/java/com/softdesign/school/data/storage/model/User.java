package com.softdesign.school.data.storage.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Users")
public class User extends Model {

    @Column(name = "firstName")
    public String mFirstName;
    @Column (name = "lastName")
    public String mLastName;

    @Column(name="team")
    public Team mTeam;

    public User() {
         super();
    }

    public User(String firstName, String lastName, Team team) {

               this.mFirstName = firstName;
               this.mLastName = lastName;
               this.mTeam = team;

    }


    public String getmFirstName() {
        return mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public Team getmTeam() {
        return mTeam;
    }
}