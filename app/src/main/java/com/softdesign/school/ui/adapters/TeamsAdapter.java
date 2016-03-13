package com.softdesign.school.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softdesign.school.R;
import com.softdesign.school.data.storage.model.Team;

import java.util.List;


public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.MyViewHolder> {

    private List<Team> mTeam;

    public TeamsAdapter(List<Team> teams) {
        this.mTeam = teams;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_add_team, parent, false);
        return new MyViewHolder(convertView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Team team = mTeam.get(position);
        holder.team.setText(team.getmTeam());

    }

    @Override
    public int getItemCount() {
        return mTeam.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        protected TextView team;


        public MyViewHolder(View convertView) {
            super(convertView);
            team = (TextView) convertView.findViewById(R.id.team_add_name);

        }
    }
}