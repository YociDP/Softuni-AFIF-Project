package org.softuni.AFIF.web.services;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.domain.entities.Role;
import org.softuni.AFIF.web.domain.entities.User;
import org.softuni.AFIF.web.domain.serviceModels.RoleServiceModel;
import org.softuni.AFIF.web.domain.serviceModels.UserServiceModel;
import org.softuni.AFIF.web.repositories.RoleRepository;
import org.softuni.AFIF.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = this.modelMapper.map(userServiceModel , User.class);
        user.setPassword(this.bCryptPasswordEncoder.encode(userServiceModel.getPassword()));

        this.insertUserRoles();
        if (this.userRepository.count() == 0) {
            Role roleServiceModel = this.roleRepository.findByAuthority("ROLE_MODERATOR");
            Role roleServiceModel1 = this.roleRepository.findByAuthority("ROLE_USER");
            Set<Role> roleServiceModels = new HashSet<>();
            roleServiceModels.add(roleServiceModel);
            roleServiceModels.add(roleServiceModel1);
            user.setAuthorities(roleServiceModels);
        }
        else
        {
            user.setAuthorities(new LinkedHashSet<>());
            Role roleServiceModel = this.roleRepository.findByAuthority("ROLE_USER");
            Set<Role> roleServiceModels = new HashSet<>();
            roleServiceModels.add(roleServiceModel);
            user.setAuthorities(roleServiceModels);
        }
        return this.modelMapper.map(this.userRepository.save(user) , UserServiceModel.class);
    }

    @Override
    public UserServiceModel findUserByUserName(String username) {
        return this.modelMapper.map(this.userRepository.findUserByUsername(username) , UserServiceModel.class);
    }

    @Override
    public List<UserServiceModel> findAllUsers() {
        return this.userRepository.findAll().stream().map(u -> this.modelMapper.map(u, UserServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public void setUserRole(String id, String role) {

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return this.userRepository
                .findUserByUsername(s);
    }

    private void insertUserRoles() {
        if (this.roleRepository.count() == 0) {
            Role role = new Role();
            role.setAuthority("ROLE_USER");

            Role adminRole = new Role();
            adminRole.setAuthority("ROLE_MODERATOR");


            this.roleRepository.save(role);
            this.roleRepository.save(adminRole);
        }
    }
}
