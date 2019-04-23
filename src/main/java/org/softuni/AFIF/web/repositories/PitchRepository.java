package org.softuni.AFIF.web.repositories;

import org.softuni.AFIF.web.domain.entities.Pitch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PitchRepository extends JpaRepository<Pitch , String> {

    public List<Pitch> findAll();

    public Pitch findFirstById(String id);
}
