package fr.myt.learn.openapi.openapidemo.controllers;

import fr.myt.learn.openapi.openapidemo.entities.Player;
import fr.myt.learn.openapi.openapidemo.repository.PlayerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class PlayerController {

    @Autowired
    PlayerPort playerPort;

    @GetMapping(value = "/players")
    List<Player> getAllPlayers() {
        return playerPort.findAll();
    }

    @GetMapping(value = "/players/{id}")
    Optional<Player> getPlayer(@PathVariable Long id) {
        if (playerPort.findById(id).isPresent()) {
            return playerPort.findById(id);
        }
        return Optional.empty();
    }

    @PostMapping(value = "players")
    Player addPlayer(@RequestBody Player player) {
        return playerPort.save(player);

    }

    @DeleteMapping(value = "/players/{id}")
    void deletePlayer(@PathVariable Long id) {
        playerPort.deleteById(id);
    }

    @PutMapping(value = "/players")
    Player updatePlayer(@RequestBody Player player) {
        return playerPort.save(player);
    }
}
