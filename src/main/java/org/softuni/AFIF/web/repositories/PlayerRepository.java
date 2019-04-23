package org.softuni.AFIF.web.repositories;

import org.softuni.AFIF.web.domain.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player , String> {

    List<Player> findAll();

    Player findFirstById(String id);
}
