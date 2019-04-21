package org.softuni.AFIF.web.services;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.models.Club;
import org.softuni.AFIF.web.models.User;
import org.softuni.AFIF.web.models.serviceModels.ClubServiceModel;
import org.softuni.AFIF.web.repositories.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ClubServiceImpl implements ClubService {
    private ModelMapper modelMapper;
    private ClubRepository clubRepository;
    private UserService userService;

    @Autowired
    public ClubServiceImpl(ModelMapper modelMapper, ClubRepository clubRepository, UserService userService) {
        this.modelMapper = modelMapper;
        this.clubRepository = clubRepository;
        this.userService = userService;
    }

    @Override
    public List<ClubServiceModel> findAll() {
        return this.clubRepository.findAll().stream()
                .map(t -> this.modelMapper.map(t , ClubServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public ClubServiceModel findById(String id) {
        return this.modelMapper.map(this.clubRepository.findFirstById(id) , ClubServiceModel.class);
    }

    @Override
    public ClubServiceModel save(ClubServiceModel clubServiceModel) {
        Club club = this.modelMapper.map(clubServiceModel , Club.class);
        this.clubRepository.saveAndFlush(club);
        return clubServiceModel;
    }

    @Override
    public List<ClubServiceModel> findClubByUserUsername(String username) {
        List<Club> allClubs = this.findAll().stream().map(t -> modelMapper.map(t , Club.class))
                .collect(Collectors.toList());
        List<ClubServiceModel> clubServiceModels = new LinkedList<>();
        for (int i = 0; i < allClubs.size(); i++) {
            if(allClubs.get(i).getFounder().getUsername().equals(username))
            {
                clubServiceModels.add(this.modelMapper.map(allClubs.get(i) , ClubServiceModel.class));
            }
        }
        return clubServiceModels;
    }


}
