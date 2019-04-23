package org.softuni.AFIF.web.services;

import org.modelmapper.ModelMapper;
import org.softuni.AFIF.web.domain.entities.Pitch;
import org.softuni.AFIF.web.domain.serviceModels.PitchServiceModel;
import org.softuni.AFIF.web.error.PitchNotFoundException;
import org.softuni.AFIF.web.repositories.PitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PitchServiceImpl implements PitchService {
    private ModelMapper modelMapper;
    private PitchRepository pitchRepository;

    @Autowired
    public PitchServiceImpl(ModelMapper modelMapper, PitchRepository pitchRepository) {
        this.modelMapper = modelMapper;
        this.pitchRepository = pitchRepository;
    }

    @Override
    public List<PitchServiceModel> findAll() {
        return this.pitchRepository.findAll().stream()
                .map(t -> this.modelMapper.map(t , PitchServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public PitchServiceModel findById(String id) {
        Pitch pitch = this.pitchRepository.findFirstById(id);
        if(pitch == null)
        {
            throw new PitchNotFoundException("Pitch with given id does not exist!");
        }
        else {
            return this.modelMapper.map(pitch, PitchServiceModel.class);
        }
    }

    @Override
    public PitchServiceModel addPitch(PitchServiceModel pitchServiceModel) {
        Pitch pitch = this.modelMapper.map(pitchServiceModel , Pitch.class);
        this.pitchRepository.saveAndFlush(pitch);
        return pitchServiceModel;
    }

    @Override
    public void delete(String id) {
        Pitch pitch = this.pitchRepository.findFirstById(id);
        pitchRepository.delete(pitch);
    }

    @Override
    public List<PitchServiceModel> findPitchesByUserUsername(String username) {
        List<Pitch> allPitches = this.findAll().stream().map(t -> modelMapper.map(t , Pitch.class))
                .collect(Collectors.toList());
        List<PitchServiceModel> pitchServiceModels = new LinkedList<>();
        for (int i = 0; i < allPitches.size(); i++) {
            if(allPitches.get(i).getOwner().getUsername().equals(username))
            {
                pitchServiceModels.add(this.modelMapper.map(allPitches.get(i) , PitchServiceModel.class));
            }
        }
        return pitchServiceModels;
    }
}
