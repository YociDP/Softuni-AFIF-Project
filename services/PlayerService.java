package org.softuni.AFIF.web.services;

import org.softuni.AFIF.web.models.Player;
import org.softuni.AFIF.web.models.requestModels.PlayerRequestModel;
import org.softuni.AFIF.web.models.serviceModels.PlayerServiceModel;

import java.util.List;

public interface PlayerService {

    List<Player> findAll();

    Player findById(String id);

    void addPlayer(Player player);

    PlayerServiceModel editPlayer(String id , PlayerServiceModel playerServiceModel);

    void deletePlayer(String id);
}
