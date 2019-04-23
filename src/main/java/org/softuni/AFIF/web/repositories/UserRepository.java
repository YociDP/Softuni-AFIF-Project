package org.softuni.AFIF.web.repositories;

import org.softuni.AFIF.web.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , String> {
    User findUserByUsername(String username);
}
