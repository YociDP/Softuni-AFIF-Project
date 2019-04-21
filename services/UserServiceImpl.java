package org.softuni.AFIF.web.services;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.models.User;
import org.softuni.AFIF.web.models.serviceModels.UserServiceModel;
import org.softuni.AFIF.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, RoleService roleService) {
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        this.roleService.seedRolesInDb();
        if(this.userRepository.count() == 0)
        {
            userServiceModel.setAuthorities(this.roleService.findAllRoles());
        }
        else
        {
            userServiceModel.setAuthorities(new LinkedHashSet<>());
            userServiceModel.getAuthorities().add(this.roleService.findByAuthority("ROLE_USER"));
        }
        User user = this.modelMapper.map(userServiceModel , User.class);
        user.setPassword(this.bCryptPasswordEncoder.encode(userServiceModel.getPassword()));
        return this.modelMapper.map(this.userRepository.saveAndFlush(user) , UserServiceModel.class);
    }

    @Override
    public UserServiceModel findUserByUserName(String username) {
        return this.modelMapper.map(this.userRepository.findUserByUsername(username) , UserServiceModel.class);
    }

    @Override
    public UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword) {
        return null;
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
}
