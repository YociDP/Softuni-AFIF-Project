package org.softuni.AFIF.web.controllers;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.domain.entities.Manager;
import org.softuni.AFIF.web.domain.bindingModels.ManagerAddBindingModel;
import org.softuni.AFIF.web.domain.bindingModels.ManagerEditBindingModel;
import org.softuni.AFIF.web.domain.serviceModels.ManagerServiceModel;
import org.softuni.AFIF.web.domain.viewModels.ManagerDetailsViewModel;
import org.softuni.AFIF.web.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/managers/")
public class ManagerController {
    private final ManagerService managerService;
    private final ModelMapper modelMapper;

    @Autowired
    public ManagerController(ManagerService managerService, ModelMapper modelMapper) {
        this.managerService = managerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("add-manager")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public String add(@ModelAttribute(name="managerAddBindingModel") ManagerAddBindingModel managerAddBindingModel)
    {
        return "add-manager";
    }

    @PostMapping("add-manager")
    public String addConfirm(@Valid @ModelAttribute("managerAddBindingModel") ManagerAddBindingModel managerAddBindingModel
            , BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "add-manager";
        }
        this.managerService.save(this.modelMapper.map(managerAddBindingModel , ManagerServiceModel.class));
        return "redirect:/managers/show-manager";
    }

    @GetMapping("show-manager")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView showManager(@ModelAttribute Manager manager , ModelAndView modelAndView)
    {
        modelAndView.addObject("managers" , this.managerService.findAll());
        modelAndView.setViewName("show-manager");
        return modelAndView;
    }

    @GetMapping("manager-details/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView managerDetails(@PathVariable String id , ModelAndView modelAndView)
    {
        modelAndView.addObject("manager" , this.modelMapper.map(this.managerService.findById(id) , ManagerDetailsViewModel.class));
        modelAndView.setViewName("manager-details");
        return modelAndView;
    }

    @GetMapping("manager-edit/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView managerEdit(@PathVariable String id , ModelAndView modelAndView)
    {
       modelAndView.addObject("manager" , this.modelMapper.map(this.managerService.findById(id) , ManagerEditBindingModel.class));
       modelAndView.setViewName("manager-edit");
       return modelAndView;
    }

    @PostMapping("manager-edit/{id}")
    public String managerEditConfirm(@PathVariable String id , @ModelAttribute ManagerEditBindingModel managerEditBindingModel)
    {
        this.managerService.editManager(id , this.modelMapper.map(managerEditBindingModel , ManagerServiceModel.class));
        return "redirect:/managers/show-manager";
    }

    @GetMapping("delete-manager/{id}")
    @PreAuthorize("hasRole('ROLE_MODERATOR')")
    public ModelAndView delete(@PathVariable String id , ModelAndView modelAndView)
    {
        modelAndView.addObject("manager" , this.modelMapper
                .map(this.managerService.findById(id) , ManagerEditBindingModel.class));
        modelAndView.setViewName("delete-manager");
        return modelAndView;
    }

    @PostMapping("delete-manager/{id}")
    public String deleteConfirm(@PathVariable String id)
    {
        this.managerService.delete(id);
        return "redirect:/managers/show-manager";
    }
}

