package org.softuni.AFIF.web.services;

import org.softuni.AFIF.web.domain.serviceModels.RoleServiceModel;

import java.util.Set;

public interface RoleService {

    void seedRolesInDb();

    Set<RoleServiceModel> findAllRoles();

    RoleServiceModel findByAuthority(String authority);
}
