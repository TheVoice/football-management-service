package com.karol.players.dao;

import com.karol.players.model.Player;

import java.util.List;

public interface PlayerDAO {

    void addPlayer(Player player);
    List<Player> getPlayers();

    void removePlayer(int id);

    Player getPlayerById(int id);

    void updatePlayer(Player player);
}
