package com.karol.players.services.impl;

import com.karol.players.dao.PlayerDAO;
import com.karol.players.model.Player;
import com.karol.players.services.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlayersServiceImpl implements PlayersService {

    private PlayerDAO playerDAO;

    @Autowired
    public void setPlayerDAO(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @Override
    @Transactional
    public List<Player> getPlayers() {
        return playerDAO.getPlayers();
    }

    @Override
    @Transactional
    public void addPlayer(Player player) {
        playerDAO.addPlayer(player);
    }

    @Override
    @Transactional
    public void removePlayer(int id) {
        playerDAO.removePlayer(id);
    }

    @Override
    @Transactional
    public Player getPlayerById(int id) {
        return playerDAO.getPlayerById(id);
    }

    @Override
    @Transactional
    public void updatePlayer(Player player) {
        playerDAO.updatePlayer(player);
    }
}
