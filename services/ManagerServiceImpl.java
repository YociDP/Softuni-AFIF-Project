package org.softuni.AFIF.web.services;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.models.Manager;
import org.softuni.AFIF.web.models.serviceModels.ManagerServiceModel;
import org.softuni.AFIF.web.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ManagerServiceImpl implements ManagerService {

    private ModelMapper modelMapper;

    private ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ModelMapper modelMapper, ManagerRepository managerRepository) {
        this.modelMapper = modelMapper;
        this.managerRepository = managerRepository;
    }

    @Override
    public List<ManagerServiceModel> findAll() {
        return this.managerRepository.findAll().stream()
                .map(x -> this.modelMapper.map(x , ManagerServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ManagerServiceModel findById(String id)
    {
        return this.modelMapper.map(this.managerRepository.findFirstById(id) , ManagerServiceModel.class);
    }

    @Override
    public ManagerServiceModel save(ManagerServiceModel managerServiceModel) {
        Manager manager = this.modelMapper.map(managerServiceModel , Manager.class);
        this.managerRepository.saveAndFlush(manager);
        return managerServiceModel;
    }

    @Override
    public ManagerServiceModel editManager(String id , ManagerServiceModel managerServiceModel) {
        Manager manager = this.managerRepository.findFirstById(id);
        manager.setAge(managerServiceModel.getAge());
        manager.setClub(managerServiceModel.getClub());
        manager.setContract(managerServiceModel.getContract());
        manager.setFirstName(managerServiceModel.getFirstName());
        manager.setLastName(managerServiceModel.getLastName());
        manager.setDivision(managerServiceModel.getDivision());
        return this.modelMapper.map(this.managerRepository.saveAndFlush(manager) , ManagerServiceModel.class);
    }

    @Override
    public void delete(String id) {
        this.managerRepository.delete(this.managerRepository.findFirstById(id));
    }
}
