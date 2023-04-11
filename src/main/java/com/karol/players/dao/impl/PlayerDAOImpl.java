package com.karol.players.dao.impl;

import com.karol.players.dao.PlayerDAO;
import com.karol.players.model.Player;
import com.karol.players.utils.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class PlayerDAOImpl implements PlayerDAO {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public void addPlayer(Player player) {
        Session session = this.sessionFactory.getCurrentSession();

        //Necessary to allow for an empty team
        if(player.getTeam().getId()==null) player.setTeam(null);

        Transaction transaction = session.beginTransaction();
        session.persist(player);
        transaction.commit();
        log.info("Player saved in database: " + player);
    }

    @Override
    public List<Player> getPlayers() {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Player> playerList = session.createQuery("from Player").list();
        log.info("Players fetched from database");
        transaction.commit();
        return playerList;
    }

    @Override
    public void removePlayer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Player player = session.load(Player.class, Integer.valueOf(id));
        if(player != null){
            session.delete(player);
            log.info("Player deleted");
        } else {
            log.info("No player with id " + id + " found in database");
        }
        transaction.commit();
    }

    @Override
    public Player getPlayerById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Player player = session.get(Player.class, id);
        transaction.commit();
        return player;
    }

    @Override
    public void updatePlayer(Player player) {
        Session session = this.sessionFactory.getCurrentSession();
        //Necessary to allow for an empty team
        if(player.getTeam().getId()==null) player.setTeam(null);
        Transaction transaction = session.beginTransaction();
        session.update(player);
        transaction.commit();
        log.info("Player updated in database: " + player);
    }
}
