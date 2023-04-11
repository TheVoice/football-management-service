package com.karol.players.services;

import com.karol.players.model.Team;

import java.util.List;

public interface TeamsService {

    List<Team> getTeams();

    void addTeam(Team team);

    void removeTeam(int id);

    Team getTeamById(int id);

    void updateTeam(Team team);
}
