package fr.myt.learn.openapi.openapidemo.repository;

import fr.myt.learn.openapi.openapidemo.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerPort extends JpaRepository<Player, Long> {

}
