package org.softuni.AFIF.web.services;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.domain.entities.Role;
import org.softuni.AFIF.web.domain.serviceModels.RoleServiceModel;
import org.softuni.AFIF.web.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedRolesInDb() {
        RoleServiceModel roleServiceModel = this.findByAuthority("ROLE_USER");
        RoleServiceModel roleServiceModel1 =  this.findByAuthority("ROLE_MODERATOR");
        if (roleServiceModel == null && roleServiceModel1 == null) {
            Role role = new Role();
            role.setAuthority("ROLE_USER");
            Role adminRole = new Role();
            adminRole.setAuthority("ROLE_MODERATOR");
            this.roleRepository.saveAndFlush(role);
            this.roleRepository.saveAndFlush(adminRole);
        }
    }

    @Override
    public Set<RoleServiceModel> findAllRoles() {
        return this.roleRepository.findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, RoleServiceModel.class))
                .collect(Collectors.toSet());
    }

    @Override
    public RoleServiceModel findByAuthority(String authority) {
        return this.modelMapper.map(this.roleRepository.findByAuthority(authority), RoleServiceModel.class);
    }
}
