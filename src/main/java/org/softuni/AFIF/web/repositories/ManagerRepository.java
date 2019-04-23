package org.softuni.AFIF.web.repositories;

import org.softuni.AFIF.web.domain.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager , String> {

    Manager findFirstById(String id);

    List<Manager> findAll();
}
