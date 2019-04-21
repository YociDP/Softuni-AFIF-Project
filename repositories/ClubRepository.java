package org.softuni.AFIF.web.repositories;

import org.softuni.AFIF.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, String> {

    List<Club> findAll();

    Club findFirstById(String id);

    Club findFirstByName(String name);
}
