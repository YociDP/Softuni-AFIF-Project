package org.softuni.AFIF.web.services;

import org.softuni.AFIF.web.domain.serviceModels.UserServiceModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUserName(String username);

    List<UserServiceModel> findAllUsers();

    void setUserRole(String id, String role);
}
