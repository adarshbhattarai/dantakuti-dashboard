package com.dantakuti.dashboard.repository;

import com.dantakuti.dashboard.document.DantaUser;
import com.dantakuti.dashboard.document.MedicalProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public  interface MedicalProfileRepository extends MongoRepository<MedicalProfile, Integer> {
}
