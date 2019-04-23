package org.softuni.AFIF.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.domain.bindingModels.PitchAddBindingModel;
import org.softuni.AFIF.web.domain.entities.User;
import org.softuni.AFIF.web.domain.serviceModels.PitchServiceModel;
import org.softuni.AFIF.web.domain.viewModels.PitchViewModel;
import org.softuni.AFIF.web.services.PitchService;
import org.softuni.AFIF.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pitches/")
public class PitchController {
    private final PitchService pitchService;
    private final ModelMapper modelMapper;
    private final UserService userService;


    @Autowired
    public PitchController(PitchService pitchService, ModelMapper modelMapper, UserService userService) {
        this.pitchService = pitchService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("buy-pitch")
    @PreAuthorize("isAuthenticated()")
    public String buyPitch(@ModelAttribute("pitch") PitchAddBindingModel pitchAddBindingModel)
    {
        return "buy-pitch";
    }

    @PostMapping("buy-pitch")
    @PreAuthorize("isAuthenticated()")
    public String buyPitchConfirm(@Valid @ModelAttribute PitchAddBindingModel pitchAddBindingModel , BindingResult bindingResult
    , Principal principal)
    {
        if(bindingResult.hasErrors())
        {
            return "buy-pitch";
        }
        User user = this.modelMapper.map(this.userService.findUserByUserName(principal.getName()) , User.class);
        pitchAddBindingModel.setOwner(user);
        PitchServiceModel pitchServiceModel = this.modelMapper.map(pitchAddBindingModel , PitchServiceModel.class);
        pitchService.addPitch(pitchServiceModel);
        return "redirect:/pitches/my-pitches";
    }

    @GetMapping("my-pitches")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView myPitches(Principal principal , ModelAndView modelAndView)
    {
        List<PitchViewModel> pitchViewModels = this.pitchService.findPitchesByUserUsername(principal.getName())
                .stream().map(t -> this.modelMapper.map(t , PitchViewModel.class))
                .collect(Collectors.toList());
        modelAndView.setViewName("my-pitches");
        modelAndView.addObject("pitches" , pitchViewModels);
        return modelAndView;
    }
}



