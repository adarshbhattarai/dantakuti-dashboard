package com.dantakuti.dashboard.controller;


import com.dantakuti.dashboard.document.MedicalProfile;
import com.dantakuti.dashboard.repository.MedicalProfileRepository;
import com.dantakuti.dashboard.service.MedicalProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("rest/medical-profile")
public class MedicalProfileController {

    @Autowired
    MedicalProfileService medicalProfileService;

    @Autowired
    private MedicalProfileRepository medicalProfileRepository;

    @GetMapping("/")
    public List<MedicalProfile> getAllMedicalProfiles(){
        return medicalProfileService.getAllMedicalProfiles();
    }

    @PostMapping("/")
    public MedicalProfile createMedicalProfile(@RequestBody MedicalProfile medicalProfile){
        return medicalProfileService.createMedicalProfile(medicalProfile);
    }

    @GetMapping("/")
    public MedicalProfile getMedicalProfileById(@RequestParam int medicalProfileId){
        return medicalProfileService.getMedicalProfileByID(medicalProfileId);
    }


    /*@PostMapping("/")
    public ResponseEntity<MedicalProfile> createMedicalProfile(@RequestBody MedicalProfile medicalProfile){

        medicalProfileService.createMedicalProfile(medicalProfile);
        return new ResponseEntity<MedicalProfile>(medicalProfile,HttpStatus.OK);

    }*/
}
