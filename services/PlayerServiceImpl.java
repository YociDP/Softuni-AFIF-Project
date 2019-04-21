package org.softuni.AFIF.web.services;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.models.Player;
import org.softuni.AFIF.web.models.serviceModels.PlayerServiceModel;
import org.softuni.AFIF.web.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Player> findAll() {
        return this.playerRepository.findAll();
    }

    @Override
    public Player findById(String id) {
        return this.playerRepository.findFirstById(id);
    }

    @Override
    public void addPlayer(Player playerRequestModel)
    {
        this.playerRepository.saveAndFlush(playerRequestModel);
    }

    @Override
    public PlayerServiceModel editPlayer(String id , PlayerServiceModel playerServiceModel) {
        Player player = this.playerRepository.findFirstById(id);
        player.setDefending(playerServiceModel.getDefending());
        player.setDribbling(playerServiceModel.getDribbling());
        player.setFirstName(playerServiceModel.getFirstName());
        player.setHeight(playerServiceModel.getHeight());
        player.setLastName(playerServiceModel.getLastName());
        player.setOverallRating(playerServiceModel.getOverallRating());
        player.setPace(playerServiceModel.getPace());
        player.setPassing(playerServiceModel.getPassing());
        player.setPhysical(playerServiceModel.getPhysical());
        player.setShooting(playerServiceModel.getShooting());
        player.setPosition(playerServiceModel.getPosition());
        player.setWeakFoot(playerServiceModel.getWeakFoot());
        player.setSkillMoves(playerServiceModel.getSkillMoves());
        player.setPrice(playerServiceModel.getPrice());
        return this.modelMapper.map(this.playerRepository.saveAndFlush(player) , PlayerServiceModel.class);
    }

    @Override
    public void deletePlayer(String id) {
        this.playerRepository.delete(this.playerRepository.findFirstById(id));
    }
}
