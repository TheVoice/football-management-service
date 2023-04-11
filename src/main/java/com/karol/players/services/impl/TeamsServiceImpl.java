package com.karol.players.services.impl;

import com.karol.players.dao.TeamDAO;
import com.karol.players.model.Team;
import com.karol.players.services.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TeamsServiceImpl implements TeamsService {

    private TeamDAO teamDAO;

    @Autowired
    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @Override
    @Transactional
    public List<Team> getTeams() {
        return this.teamDAO.getTeams();
    }

    @Override
    @Transactional
    public void addTeam(Team team) {
        this.teamDAO.addTeam(team);
    }

    @Override
    @Transactional
    public void removeTeam(int id) {
        this.teamDAO.removeTeam(id);
    }

    @Override
    @Transactional
    public Team getTeamById(int id) {
        return teamDAO.getTeamById(id);
    }

    @Override
    @Transactional
    public void updateTeam(Team team) {
        teamDAO.updateTeam(team);
    }
}
