package com.dantakuti.dashboard.service.impl;

import com.dantakuti.dashboard.document.MedicalProfile;
import com.dantakuti.dashboard.repository.MedicalProfileRepository;
import com.dantakuti.dashboard.service.MedicalProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalProfileServiceImpl implements MedicalProfileService {

    @Autowired
    MedicalProfileRepository medicalProfileRepository;

    @Override
    public List<MedicalProfile> getAllMedicalProfiles() {
        return medicalProfileRepository.findAll();
    }

    @Override
    public MedicalProfile createMedicalProfile(MedicalProfile medicalProfile) {
        return medicalProfileRepository.save(medicalProfile);
    }

    @Override
    public MedicalProfile getMedicalProfileByID(int medicalProfileID) {
        Optional<MedicalProfile> optinalEntity =  medicalProfileRepository.findById(medicalProfileID);
        MedicalProfile medicalProfileEntity = optinalEntity.get();
        return medicalProfileEntity;
    }

}
