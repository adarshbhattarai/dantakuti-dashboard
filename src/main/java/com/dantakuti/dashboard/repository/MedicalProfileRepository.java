package com.dantakuti.dashboard.repository;

import com.dantakuti.dashboard.document.DantaUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public  interface UserRepository extends MongoRepository<DantaUser, Integer> {

    DantaUser findByEmail(String email);
}
