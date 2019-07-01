package com.dantakuti.dashboard.service;

import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.document.MedicalProfile;

import java.util.List;

public interface MedicalProfileService {

   public List<MedicalProfile> getAllMedicalProfiles();

   public MedicalProfile createMedicalProfile(MedicalProfile medicalProfile);

   public MedicalProfile getMedicalProfileByID(int medicalProfileID);


}
