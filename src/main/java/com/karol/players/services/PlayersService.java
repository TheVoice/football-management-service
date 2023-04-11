package com.karol.players.services;

import com.karol.players.model.Player;

import java.util.List;

public interface PlayersService {

    List<Player> getPlayers();

    void addPlayer(Player player);

    void removePlayer(int id);

    Player getPlayerById(int id);

    void updatePlayer(Player player);
}
