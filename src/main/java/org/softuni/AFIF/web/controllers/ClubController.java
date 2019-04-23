package org.softuni.AFIF.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.domain.entities.User;
import org.softuni.AFIF.web.domain.bindingModels.ClubAddBindingModel;
import org.softuni.AFIF.web.domain.serviceModels.ClubServiceModel;
import org.softuni.AFIF.web.domain.viewModels.ClubViewModel;
import org.softuni.AFIF.web.services.ClubService;
import org.softuni.AFIF.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/clubs/")
public class ClubController {
    private final ClubService clubService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public ClubController(ClubService clubService, UserService userService, ModelMapper modelMapper) {
        this.clubService = clubService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("create-club")
    @PreAuthorize("isAuthenticated()")
    public String add(@ModelAttribute("clubAddBindingModel") ClubAddBindingModel clubAddBindingModel)
    {
        return "create-club";
    }

    @PostMapping("create-club")
    public String addConfirm(@Valid @ModelAttribute ClubAddBindingModel clubAddBindingModel , BindingResult bindingResult
            , Principal principal)
    {
        if(bindingResult.hasErrors())
        {
            return "create-club";
        }
        User user = this.modelMapper.map(this.userService.findUserByUserName(principal.getName()) , User.class);
        clubAddBindingModel.setFounder(user);
        ClubServiceModel clubServiceModel = this.modelMapper.map(clubAddBindingModel , ClubServiceModel.class);
        clubService.save(clubServiceModel);
        return "redirect:/clubs/my-club";
    }

    @GetMapping("my-club")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView myClub(Principal principal, ModelAndView modelAndView)
    {
        List<ClubViewModel> clubViewModels = this.clubService.findClubByUserUsername(principal.getName()).stream()
                .map(t -> this.modelMapper.map(t , ClubViewModel.class)).collect(Collectors.toList());
        modelAndView.setViewName("my-club");
        modelAndView.addObject("clubs" , clubViewModels);
        return modelAndView;
    }


}
