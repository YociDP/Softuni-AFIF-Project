package org.softuni.AFIF.web.services;

import org.softuni.AFIF.web.models.Club;
import org.softuni.AFIF.web.models.serviceModels.ClubServiceModel;

import java.util.List;

public interface ClubService {
    List<ClubServiceModel> findAll();

    ClubServiceModel findById(String id);

    ClubServiceModel save(ClubServiceModel clubServiceModel);

    List<ClubServiceModel> findClubByUserUsername(String username);
}
