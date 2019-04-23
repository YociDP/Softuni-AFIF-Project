package org.softuni.AFIF.web.services;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.error.PlayerNotFoundException;
import org.softuni.AFIF.web.domain.entities.Player;
import org.softuni.AFIF.web.domain.serviceModels.PlayerServiceModel;
import org.softuni.AFIF.web.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<PlayerServiceModel> findAll() {
        return this.playerRepository.findAll()
                .stream().map(t -> this.modelMapper.map(t , PlayerServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlayerServiceModel findById(String id) {
        Player player = this.playerRepository.findFirstById(id);
        if(player == null)
        {
            throw new PlayerNotFoundException("Player with given id does not exist!");
        }
        else {
            return this.modelMapper.map(this.playerRepository.findFirstById(id), PlayerServiceModel.class);
        }
    }

    @Override
    public PlayerServiceModel addPlayer(PlayerServiceModel playerRequestModel)
    {
        return this.modelMapper.map(this.playerRepository.saveAndFlush(this.modelMapper.map(playerRequestModel , Player.class)) , PlayerServiceModel.class);
    }

    @Override
    public PlayerServiceModel editPlayer(String id , PlayerServiceModel playerServiceModel) {
        Player player = this.playerRepository.findFirstById(id);
        if(player == null)
        {
            throw new PlayerNotFoundException("Player with given id does not exist!");
        }
        else {
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
            return this.modelMapper.map(this.playerRepository.saveAndFlush(player), PlayerServiceModel.class);
        }
    }

    @Override
    public void deletePlayer(String id) {
        Player player = this.playerRepository.findFirstById(id);
        if(player == null)
        {
            throw new PlayerNotFoundException("Player with given id does not exist!");
        }
        else {
            this.playerRepository.delete(player);
        }
    }
}
