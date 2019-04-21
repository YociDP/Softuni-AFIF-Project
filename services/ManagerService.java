package org.softuni.AFIF.web.services;

import org.softuni.AFIF.web.models.Manager;
import org.softuni.AFIF.web.models.serviceModels.ManagerServiceModel;

import java.util.List;

public interface ManagerService {

    List<ManagerServiceModel> findAll();

    ManagerServiceModel findById(String id);

    ManagerServiceModel save(ManagerServiceModel managerServiceModel);

    ManagerServiceModel editManager(String id , ManagerServiceModel managerServiceModel);

    void delete(String id);
}
