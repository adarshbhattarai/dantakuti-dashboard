package com.dantakuti.dashboard.repository;

import com.dantakuti.dashboard.document.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, Integer> {
    Role findByRole(String role);
}
