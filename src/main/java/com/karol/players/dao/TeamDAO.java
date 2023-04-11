package com.karol.players.dao;

import com.karol.players.model.Team;

import java.util.List;

public interface TeamDAO {

    void addTeam(Team team);
    List<Team> getTeams();

    void removeTeam(int id);

    Team getTeamById(int id);

    void updateTeam(Team team);
}
