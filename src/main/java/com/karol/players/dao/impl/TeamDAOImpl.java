package com.karol.players.dao.impl;

import com.karol.players.dao.TeamDAO;
import com.karol.players.model.Player;
import com.karol.players.model.Team;
import com.karol.players.utils.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class TeamDAOImpl implements TeamDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addTeam(Team team) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.persist(team);
        transaction.commit();
        log.info("Team saved in database: " + team);
    }

    @Override
    public List<Team> getTeams() {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Team> teamList = session.createQuery("from Team").list();
        log.info("Teams fetched from database");
        transaction.commit();
        return teamList;
    }

    @Override
    public void removeTeam(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Team team = session.load(Team.class, Integer.valueOf(id));
        if(team != null){
            //Removing the team for associated players
            for(Player player : team.getPlayers()){
                player.setTeam(null);
            }
            session.delete(team);
            log.info("Team deleted");
        } else {
            log.info("No team with id " + id + " found in database");
        }
        transaction.commit();
    }

    @Override
    public Team getTeamById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Team team = session.get(Team.class, id);
        transaction.commit();
        return team;
    }

    @Override
    public void updateTeam(Team team) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(team);
        transaction.commit();
        log.info("Team updated in database: " + team);
    }
}
