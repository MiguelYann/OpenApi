package fr.myt.learn.openapi.openapidemo.core;

import fr.myt.learn.openapi.openapidemo.entities.Player;

import java.util.List;

public interface PlayerService {
    Player addPlayer(Player player);

    List<Player> getAllPlayers();

    Player getPlayer(Long id);

    void deletePlayer(Long id);

    Player updatePlayer(Player player);
}
