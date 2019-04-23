package org.softuni.AFIF.web.services;

import org.softuni.AFIF.web.domain.serviceModels.PitchServiceModel;

import java.util.List;

public interface PitchService {
    List<PitchServiceModel> findAll();

    PitchServiceModel findById(String id);

    PitchServiceModel addPitch(PitchServiceModel pitchServiceModel);

    void delete(String id);

    List<PitchServiceModel> findPitchesByUserUsername(String username);
}
