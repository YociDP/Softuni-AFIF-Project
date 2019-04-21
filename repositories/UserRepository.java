package org.softuni.AFIF.web.repositories;

import org.softuni.AFIF.web.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User , String> {
    User findUserByUsername(String username);
}
