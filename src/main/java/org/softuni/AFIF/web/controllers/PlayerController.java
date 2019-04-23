package org.softuni.AFIF.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.domain.entities.Player;
import org.softuni.AFIF.web.domain.bindingModels.PlayerEditBindingModel;
import org.softuni.AFIF.web.domain.serviceModels.PlayerServiceModel;
import org.softuni.AFIF.web.domain.viewModels.PlayerDetailsViewModel;
import org.softuni.AFIF.web.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/players/")
public class PlayerController{
    private final PlayerService playerService;
    private final ModelMapper modelMapper;

    @Autowired
    public PlayerController(PlayerService playerService, ModelMapper modelMapper) {
        this.playerService = playerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("add-player")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public String add(@ModelAttribute(name="playerRequestModel") PlayerEditBindingModel playerEditBindingModel)
    {
        return "add-player";
    }

    @PostMapping("add-player")
    public String addPost(@Valid @ModelAttribute(name = "playerRequestModel") PlayerEditBindingModel playerEditBindingModel , BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "add-player";
        }
        this.playerService.addPlayer(this.modelMapper.map(playerEditBindingModel , PlayerServiceModel.class));
        return "redirect:/players/show-players";
    }

    @GetMapping("show-players")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView show(@ModelAttribute("playerRequestModel") Player player , ModelAndView modelAndView)
    {
        modelAndView.addObject("players" , this.playerService.findAll());
        modelAndView.setViewName("show-players");
        return modelAndView;
    }

    @GetMapping("player-details/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView details(@PathVariable String id , ModelAndView modelAndView)
    {
        modelAndView.addObject("player" , this.modelMapper.map(this.playerService.findById(id) , PlayerDetailsViewModel.class));
        modelAndView.setViewName("player-details");
        return modelAndView;
    }

    @GetMapping("edit-player/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView edit(@PathVariable String id ,ModelAndView modelAndView)
    {
        modelAndView.addObject("player" , this.modelMapper.map(this.playerService.findById(id) , PlayerEditBindingModel.class));
        modelAndView.setViewName("edit-player");
        return modelAndView;
    }

    @PostMapping("edit-player/{id}")
    public String editConfirm(@PathVariable String id , @ModelAttribute PlayerEditBindingModel playerEditBindingModel)
    {
        this.playerService.editPlayer(id , this.modelMapper.map(playerEditBindingModel , PlayerServiceModel.class));
        return "redirect:/players/show-players";
    }

    @GetMapping("delete-player/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView delete(@PathVariable String id , ModelAndView modelAndView)
    {
        PlayerEditBindingModel playerEditBindingModel = this.modelMapper
                .map(this.playerService.findById(id) , PlayerEditBindingModel.class);
        modelAndView.addObject("player" , playerEditBindingModel);
        modelAndView.setViewName("delete-player");
        return modelAndView;
    }

    @PostMapping("delete-player/{id}")
    public String deleteConfirm(@PathVariable String id)
    {
        this.playerService.deletePlayer(id);
        return "redirect:/players/show-players";
    }
}
