package com.softdesign.school.data.storage.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

@Table(name = "Teams")
public class Team extends Model {

    @Column (name = "teamName")
    public String mTeam;

    public Team() {
        super();
    }

    public Team(String teamName) {
        this.mTeam = teamName;
    }

    public String getmTeam() {
        return mTeam;
    }
    public List<User> users() {
                return getMany(User.class, "team");
            }
}