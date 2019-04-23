package org.softuni.AFIF.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.domain.bindingModels.UserRegisterBindingModel;
import org.softuni.AFIF.web.domain.serviceModels.ClubServiceModel;
import org.softuni.AFIF.web.domain.serviceModels.PitchServiceModel;
import org.softuni.AFIF.web.domain.serviceModels.UserServiceModel;
import org.softuni.AFIF.web.services.ClubService;
import org.softuni.AFIF.web.services.PitchService;
import org.softuni.AFIF.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    private final ClubService clubService;
    private final PitchService pitchService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ClubService clubService, PitchService pitchService, ModelMapper modelMapper) {
        this.userService = userService;
        this.clubService = clubService;
        this.pitchService = pitchService;
        this.modelMapper = modelMapper;

    }

    @GetMapping("users/register")
    @PreAuthorize("isAnonymous()")
    public String register(){
        return "register";
    }

    @PostMapping("users/register")
    @PreAuthorize("isAnonymous()")
    public String registerConfirm(@ModelAttribute UserRegisterBindingModel model) {
        if (!model.getPassword().equals(model.getConfirmPassword())) {
            return "register";
        }

        this.userService.registerUser(this.modelMapper.map(model, UserServiceModel.class));

        return "redirect:/login";
    }

    @GetMapping("users/login")
    @PreAuthorize("isAnonymous()")
    public String login()
    {
        return "login";
    }

    @GetMapping("home")
    public ModelAndView viewHome(Principal principal , ModelAndView modelAndView)
    {
        List<PitchServiceModel> pitchServiceModelList = this.pitchService.findPitchesByUserUsername(principal.getName());
        List<ClubServiceModel> clubServiceModels = this.clubService.findClubByUserUsername(principal.getName());
        modelAndView.addObject("clubs" , clubServiceModels);
        modelAndView.addObject("pitches" , pitchServiceModelList);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping()
    public String view()
    {
        return "index";
    }
}
