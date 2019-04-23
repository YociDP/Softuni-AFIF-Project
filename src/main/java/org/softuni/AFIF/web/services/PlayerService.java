package org.softuni.AFIF.web.services;

import org.softuni.AFIF.web.domain.serviceModels.PlayerServiceModel;

import java.util.List;

public interface PlayerService {

    List<PlayerServiceModel> findAll();

    PlayerServiceModel findById(String id);

    PlayerServiceModel addPlayer(PlayerServiceModel player);

    PlayerServiceModel editPlayer(String id , PlayerServiceModel playerServiceModel);

    void deletePlayer(String id);
}
