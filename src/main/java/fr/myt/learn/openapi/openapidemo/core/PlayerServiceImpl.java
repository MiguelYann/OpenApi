package fr.myt.learn.openapi.openapidemo.core;

import fr.myt.learn.openapi.openapidemo.entities.Player;
import fr.myt.learn.openapi.openapidemo.repository.PlayerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerServiceImpl {

    private final PlayerPort playerPort;

    public PlayerServiceImpl(PlayerPort port) {
        this.playerPort = port;
    }


    public Player addPlayer(Player player) {
        return this.playerPort.save(player);
    }

//    @Override
//    public List<Player> getAllPlayers() {
//        return this.playerPort.findAll();
//    }

    public Player getPlayer(Long id) {
        return this.playerPort.findById(id).get();
    }

    public void deletePlayer(Long id) {
        this.deletePlayer(id);
    }
//
//    @Override
//    public Player updatePlayer(Player player) {
//        return this.playerPort.(player);
//    }
}
